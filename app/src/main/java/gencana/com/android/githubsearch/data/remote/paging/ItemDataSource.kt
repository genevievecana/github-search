package gencana.com.android.githubsearch.data.remote.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import gencana.com.android.githubsearch.common.model.PagingListModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class ItemDataSource<T: PagingListModel<M>, M>(
        private val pageObservable: (page: Int) -> Observable<T>,
        private val io: Scheduler,
        private val compositeDisposable: CompositeDisposable,
        private val loadingLiveData: MutableLiveData<Boolean>,
        private val errorLiveData: MutableLiveData<String>,
        private val pageSize: Int = 30)
    : PageKeyedDataSource<Int, M>() {

    override fun loadInitial(params: PageKeyedDataSource.LoadInitialParams<Int>, callback: PageKeyedDataSource.LoadInitialCallback<Int, M>) {
        pageObservable(1)
                .subscribeOn(io)
                .doOnSubscribe{loadingLiveData.postValue(true)}
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {response ->
                            loadingLiveData.postValue(false)
                            callback.onResult(response.data!!, null, 2)
                        },
                        {
                            loadingLiveData.postValue(false)
                            errorLiveData.postValue(it.message)
                        })
                ?.let { compositeDisposable.add(it) }
    }

    override fun loadBefore(params: PageKeyedDataSource.LoadParams<Int>, callback: PageKeyedDataSource.LoadCallback<Int, M>) {

    }

    override fun loadAfter(params: PageKeyedDataSource.LoadParams<Int>, callback: PageKeyedDataSource.LoadCallback<Int, M>) {
        pageObservable(params.key)
                .subscribeOn(io)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            val key = if (it.totalCount > (pageSize+1)*params.key) params.key + 1 else null
                            callback.onResult(it.data!!, key)
                        },
                        {
                            errorLiveData.postValue(it.message)
                        })
                ?.let { compositeDisposable.add(it) }
    }

}
