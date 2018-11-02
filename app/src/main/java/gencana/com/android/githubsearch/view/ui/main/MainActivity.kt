package gencana.com.android.githubsearch.view.ui.main

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.paging.PagedList
import gencana.com.android.githubsearch.R
import gencana.com.android.githubsearch.common.extensions.defaultMultiAdapter
import gencana.com.android.githubsearch.common.extensions.isVisible
import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.SearchParams
import gencana.com.android.githubsearch.common.model.UserModel
import gencana.com.android.githubsearch.view.ui.adapter.RecyclerMultiAdapter
import gencana.com.android.githubsearch.view.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, PagingListModel<UserModel>, PagedList<UserModel>>() {

    private lateinit var recyclerMultiAdapter: RecyclerMultiAdapter<UserModel>

    override val layout: Int
        get() = R.layout.activity_main

    override fun setupActivity(savedInstanceState: Bundle?) {
        placeholder_view.setup(swipe_refresh_main, getString(R.string.error_empty_initial))
        recyclerMultiAdapter = recycler_main.defaultMultiAdapter(false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        setupSearch(menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun search(searchParams: SearchParams){
        if (searchParams.query.isEmpty()){
            onError(getString(R.string.error_empty_query))
            return
        }

        viewModel.executePaging(searchParams)
    }

    override fun showLoading(show: Boolean) {
        if (placeholder_view.isVisible()){
            placeholder_view.showLoading(show)
        }else{
            swipe_refresh_main.isRefreshing = show
        }
    }

    override fun onResponseSuccess(data: PagedList<UserModel>) {
        placeholder_view.hideError()
        recyclerMultiAdapter.submitList(data)
    }

    override fun onError(errorMsg: String?) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
        placeholder_view.showError(errorMsg)
    }

    override fun onSuccessEmptyResults() {
        placeholder_view.showEmpty(getString(R.string.error_empty_results))
    }

    private fun setupSearch(menu: Menu?){
        menu?.apply {
            findItem(R.id.action_search).let {
                (it.actionView as SearchView).apply {
                    swipe_refresh_main.setOnRefreshListener {
                        search(SearchParams(this.query.toString()  , 1))
                    }

                    maxWidth = Integer.MAX_VALUE
                    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextChange(newText: String?): Boolean {
                            return true
                        }

                        override fun onQueryTextSubmit(query: String?): Boolean {
                            search(SearchParams(query!!, 1))
                            it.collapseActionView()
                            return false
                        }

                    })
                } }
            }

    }

}
