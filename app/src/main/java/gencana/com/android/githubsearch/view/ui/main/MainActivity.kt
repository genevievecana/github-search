package gencana.com.android.githubsearch.view.ui.main

import android.os.Bundle
import android.widget.Toast
import gencana.com.android.githubsearch.R
import gencana.com.android.githubsearch.common.extensions.defaultMultiAdapter
import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.SearchParams
import gencana.com.android.githubsearch.common.model.UserModel
import gencana.com.android.githubsearch.view.ui.adapter.RecyclerMultiAdapter
import gencana.com.android.githubsearch.view.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, PagingListModel<UserModel>>() {

    private lateinit var recyclerMultiAdapter: RecyclerMultiAdapter<UserModel>

    override val layout: Int
        get() = R.layout.activity_main

    override fun setupActivity(savedInstanceState: Bundle?) {
        recyclerMultiAdapter = recycler_main.defaultMultiAdapter()
        viewModel.execute(SearchParams("gen", 1))
    }

    override fun showLoading(show: Boolean) {
        swipe_refresh_main.isRefreshing = show
    }

    override fun onResponseSuccess(data: PagingListModel<UserModel>) {
        recyclerMultiAdapter.addItems(data.data)
    }

    override fun onError(errorMsg: String?) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
    }
}
