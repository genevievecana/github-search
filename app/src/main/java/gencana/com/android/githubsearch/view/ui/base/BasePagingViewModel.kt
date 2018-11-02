package gencana.com.android.githubsearch.view.ui.base

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.ResultEvent
import gencana.com.android.githubsearch.view.adapter.paging.getPagingLiveData
import io.reactivex.Observable
import io.reactivex.Scheduler

abstract class BasePagingViewModel<T: PagingListModel<M>, M, Params>(
        private val io: Scheduler
): BaseViewModel<T, Params>(io){

    abstract fun getPagedObservable(params: Params): (page: Int) -> Observable<T>

    fun executePaging(params: Params){
        resultStateLiveData.addSource(createPagedLiveData(params)){
            resultStateLiveData.value = ResultEvent.OnSuccess(it)
        }
    }

    private fun createPagedLiveData(params: Params): LiveData<PagedList<M>>
            = getPagingLiveData(
                compositeDisposable,
                io,
                resultStateLiveData,
                getPagedObservable(params))

}