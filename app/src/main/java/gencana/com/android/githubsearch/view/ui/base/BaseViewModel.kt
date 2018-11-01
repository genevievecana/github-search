package gencana.com.android.githubsearch.view.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gencana.com.android.githubsearch.common.extensions.addErrorHandler
import gencana.com.android.githubsearch.common.model.Result
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.CompositeDisposable


abstract class BaseViewModel<T, Params>(private val io: Scheduler) : ViewModel() {

    protected val compositeDisposable by lazy { CompositeDisposable() }
    val responseLiveData by lazy { MutableLiveData<T>() }
    val loadingLiveData by lazy { MutableLiveData<Boolean>() }
    val errorLiveData by lazy { MutableLiveData<String>() }

    abstract fun getObservable(params: Params): Observable<T>

    fun execute(params: Params, showError: Boolean = true){
        execute(getObservable(params), showError)
    }

    //TODO: design also for paging
    fun execute(single: Observable<T>, showError: Boolean = true){
//        if (showError) single.addErrorHandler()
        addDisposable(single
                .doOnSubscribe{loadingLiveData.postValue(true)}
                .doAfterTerminate{loadingLiveData.postValue(false)}
                .subscribeOn(io)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
//                    if (result.hasError()) errorLiveData.postValue(result.error)
//                    else responseLiveData.postValue(result.data)
                    responseLiveData.postValue(result)
                }, { throwable ->
                    if (showError)errorLiveData.postValue(throwable.message)
                })
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