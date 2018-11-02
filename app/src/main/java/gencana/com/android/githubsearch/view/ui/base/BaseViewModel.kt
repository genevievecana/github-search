package gencana.com.android.githubsearch.view.ui.base

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import gencana.com.android.githubsearch.common.extensions.switchMapError
import gencana.com.android.githubsearch.common.model.ResultEvent
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.CompositeDisposable


abstract class BaseViewModel<T, Params>(private val io: Scheduler) : ViewModel() {

    protected val compositeDisposable by lazy { CompositeDisposable() }
    val resultStateLiveData = MediatorLiveData<ResultEvent>()

    abstract fun getObservable(params: Params): Observable<T>

    fun execute(params: Params){
        execute(getObservable(params))
    }

    fun execute(single: Observable<T>){
        addDisposable(
                switchMapError(single)
                .doOnSubscribe{resultStateLiveData.postValue(ResultEvent.OnStart())}
                .subscribeOn(io)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            resultStateLiveData.value = ResultEvent.OnFinish()
                            resultStateLiveData.value = ResultEvent.OnSuccess(it)
                        },
                        {
                            resultStateLiveData.value = ResultEvent.OnFinish()
                            resultStateLiveData.value = ResultEvent.OnError(it)
                        }
                )
        )
    }

    fun addDisposable(disposable: Disposable?){
        disposable
                ?.let { compositeDisposable.add(it) }
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}