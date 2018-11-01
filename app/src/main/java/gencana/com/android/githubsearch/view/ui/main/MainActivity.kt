package gencana.com.android.githubsearch.view.ui.main

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import gencana.com.android.githubsearch.R
import gencana.com.android.githubsearch.common.extensions.addObserver
import gencana.com.android.githubsearch.common.extensions.defaultMultiAdapter
import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.SearchParams
import gencana.com.android.githubsearch.common.model.UserModel
import gencana.com.android.githubsearch.view.ui.adapter.RecyclerMultiAdapter
import gencana.com.android.githubsearch.view.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, PagingListModel<UserModel>>() {

    private lateinit var recyclerMultiAdapter: RecyclerMultiAdapter<UserModel>

    private val defaultParams = SearchParams("gen", 1)

    override val layout: Int
        get() = R.layout.activity_main

    override fun setupActivity(savedInstanceState: Bundle?) {
        recyclerMultiAdapter = recycler_main.defaultMultiAdapter()

        search(defaultParams)
    }

    private fun search(searchParams: SearchParams){
        if (searchParams.query.isEmpty()){
            onError("Search is empty!")
            return
        }

        viewModel.itemPagedList(searchParams)
                .addObserver(this) {  recyclerMultiAdapter.submitList(it)}
    }

    override fun showLoading(show: Boolean) {
        swipe_refresh_main.isRefreshing = show
    }

    override fun onResponseSuccess(data: PagingListModel<UserModel>) {

    }

    override fun onError(errorMsg: String?) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        setupSearch(menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setupSearch(menu: Menu?){
        menu?.apply {
            (findItem(R.id.action_search).actionView as SearchView).apply {
                swipe_refresh_main.setOnRefreshListener {
                    search(
                            if (this.query.toString().isEmpty()) defaultParams
                            else SearchParams(this.query.toString()  , 1)
                    )
                }
                maxWidth = Integer.MAX_VALUE
                setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextChange(newText: String?): Boolean {
                        return true
                    }

                    override fun onQueryTextSubmit(query: String?): Boolean {
                        search(SearchParams(query!!, 1))
                        return false
                    }

                })
            } }
    }

}
