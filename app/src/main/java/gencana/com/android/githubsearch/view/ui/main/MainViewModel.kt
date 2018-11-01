package gencana.com.android.githubsearch.view.ui.main

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.SearchParams
import gencana.com.android.githubsearch.common.model.UserModel
import gencana.com.android.githubsearch.data.remote.paging.getPagingLiveData
import gencana.com.android.githubsearch.interactor.UserInteractor
import gencana.com.android.githubsearch.view.ui.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject


class MainViewModel @Inject constructor(
        private val airportListDetailsInteractor: UserInteractor,
        private val io: Scheduler
): BaseViewModel<PagingListModel<UserModel>, SearchParams>(io) {

    override fun getObservable(params: SearchParams): Observable<PagingListModel<UserModel>> {
        return airportListDetailsInteractor
                .getObservable(params)
                .toObservable()

    }

    fun itemPagedList(params: SearchParams): LiveData<PagedList<UserModel>>
            = getPagingLiveData(
                    compositeDisposable,
                    io,
                    loadingLiveData,
                    errorLiveData,
                    { page: Int ->
                            params.page = page
                    getObservable(params)
                    })


}