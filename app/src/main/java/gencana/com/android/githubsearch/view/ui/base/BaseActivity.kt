package gencana.com.android.githubsearch.view.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import gencana.com.android.githubsearch.common.extensions.addObserver
import gencana.com.android.githubsearch.common.model.ResultEvent
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseActivity<VM: BaseViewModel<T, *>, T, R>: AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM
    protected abstract val layout: Int

    protected abstract fun setupActivity(savedInstanceState: Bundle?)
    protected abstract fun showLoading(show: Boolean)
    abstract fun onResponseSuccess(data: R)
    abstract fun onError(errorMsg: String?)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layout)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>)
        observeLiveData()
        setupActivity(savedInstanceState)
    }

    @Suppress("UNCHECKED_CAST")
    private fun observeLiveData() {
        viewModel.resultStateLiveData.addObserver(this) {
            it. apply {
                when(this){
                    is ResultEvent.OnStart -> onRequestStarted(isPaging)
                    is ResultEvent.OnFinish -> onRequestFinished(isPaging)
                    is ResultEvent.OnSuccess<*> -> onResponseSuccess(data as R)
                    ResultEvent.OnEmptyResults -> onSuccessEmptyResults()
                    is ResultEvent.OnError -> onError(throwable.message)
                    is ResultEvent.OnExpectedError -> onError(errorEnum.errorMessage)
                }
            }

        }

    }

    protected open fun onRequestStarted(isPaging: Boolean){
        if (!isPaging)
            showLoading(true)

    }

    protected open fun onRequestFinished(isPaging: Boolean){
        if (!isPaging)
            showLoading(false)
    }

    protected open fun onSuccessEmptyResults(){

    }

}