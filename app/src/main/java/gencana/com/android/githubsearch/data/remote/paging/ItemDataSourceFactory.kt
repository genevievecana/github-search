package gencana.com.android.githubsearch.data.remote.paging

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import androidx.paging.DataSource
import gencana.com.android.githubsearch.common.model.PagingListModel
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable


class ItemDataSourceFactory<T: PagingListModel<M>, M>(private val pageObservable: (page: Int) -> Observable<T>,
                                                      private val io: Scheduler,
                                                      private val compositeDisposable: CompositeDisposable,
                                                      private val loadingLiveData: MutableLiveData<Boolean>,
                                                      private val errorLiveData: MutableLiveData<String>
                                                      )
    : DataSource.Factory<Int, M>() {

    override fun create(): DataSource<Int, M> {
        return ItemDataSource(pageObservable, io, compositeDisposable, loadingLiveData, errorLiveData)
    }
}
