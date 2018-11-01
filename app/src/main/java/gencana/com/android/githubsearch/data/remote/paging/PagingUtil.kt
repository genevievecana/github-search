package gencana.com.android.githubsearch.data.remote.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import gencana.com.android.githubsearch.common.model.PagingListModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

fun<T: PagingListModel<M>, M> getPagingLiveData(
        compositeDisposable: CompositeDisposable,
        io: Scheduler,
        loadingLiveData: MutableLiveData<Boolean>,
        errorLiveData: MutableLiveData<String>,
        pageObservable: (page: Int) -> Observable<T>,
        pageSize: Int = 30)
        : LiveData<PagedList<M>>{
    val itemDataSourceFactory
            = ItemDataSourceFactory(pageObservable, io, compositeDisposable, loadingLiveData, errorLiveData)
    return LivePagedListBuilder(itemDataSourceFactory, getDefaultPageListConfiguration(pageSize))
            .build()
}

fun getDefaultPageListConfiguration(pageSize: Int, prefetch: Int = 30) : PagedList.Config
        = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPageSize(pageSize)
        .setPrefetchDistance(prefetch)
        .build()
