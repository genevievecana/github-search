package gencana.com.android.githubsearch.data.remote.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.ResultEvent
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

fun<T: PagingListModel<M>, M> getPagingLiveData(
        compositeDisposable: CompositeDisposable,
        io: Scheduler,
        liveDataResponseEvent: MutableLiveData<ResultEvent>,
        pageObservable: (page: Int) -> Observable<T>,
        pageSize: Int = 30)
        : LiveData<PagedList<M>>{
    val itemDataSourceFactory
            = ItemDataSourceFactory(pageObservable, io, compositeDisposable, liveDataResponseEvent)
    return LivePagedListBuilder(itemDataSourceFactory, getDefaultPageListConfiguration(pageSize))
            .build()
}

fun getDefaultPageListConfiguration(pageSize: Int, prefetch: Int = 30) : PagedList.Config
        = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setPageSize(pageSize)
        .setPrefetchDistance(prefetch)
        .build()
