package gencana.com.android.githubsearch.data.remote.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import gencana.com.android.githubsearch.common.extensions.switchMapError
import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.ResultEvent
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class ItemDataSource<T: PagingListModel<M>, M>(
        private val pageObservable: (page: Int) -> Observable<T>,
        private val io: Scheduler,
        private val compositeDisposable: CompositeDisposable,
        private val liveDataResponseEvent: MutableLiveData<ResultEvent>,
        private val pageSize: Int = 30)
    : PageKeyedDataSource<Int, M>() {

    @Suppress("UNCHECKED_CAST")
    override fun loadInitial(params: PageKeyedDataSource.LoadInitialParams<Int>, callback: PageKeyedDataSource.LoadInitialCallback<Int, M>) {
        switchMapError(pageObservable(1))
                .doOnSubscribe{liveDataResponseEvent.postValue(ResultEvent.OnStart())}
                .subscribeOn(io)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {response ->
                            response as ResultEvent.OnSuccess<PagingListModel<M>>
                            liveDataResponseEvent.value = ResultEvent.OnFinish()
                            response.data.data.apply {
                                if (isEmpty()) liveDataResponseEvent.value = ResultEvent.OnEmptyResults
                                else callback.onResult(response.data.data, null, 2)
                            }
                        },
                        {
                            liveDataResponseEvent.value = ResultEvent.OnFinish()
                            liveDataResponseEvent.value = ResultEvent.OnError(it)
                        })
                ?.let { compositeDisposable.add(it) }
    }

    override fun loadBefore(params: PageKeyedDataSource.LoadParams<Int>, callback: PageKeyedDataSource.LoadCallback<Int, M>) {

    }

    @Suppress("UNCHECKED_CAST")
    override fun loadAfter(params: PageKeyedDataSource.LoadParams<Int>, callback: PageKeyedDataSource.LoadCallback<Int, M>) {
        switchMapError(pageObservable(params.key))
                .doOnSubscribe{liveDataResponseEvent.postValue(ResultEvent.OnStart(true))}
                .subscribeOn(io)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            it as ResultEvent.OnSuccess<PagingListModel<M>>
                            liveDataResponseEvent.value = ResultEvent.OnFinish(true)
                            val key = if (it.data.totalCount > (pageSize+1)*params.key) params.key + 1 else null
                            callback.onResult(it.data.data, key)
                        },
                        {
                            liveDataResponseEvent.value = ResultEvent.OnFinish(true)
                            liveDataResponseEvent.value = ResultEvent.OnError(it)
                        })
                ?.let { compositeDisposable.add(it) }
    }

}
