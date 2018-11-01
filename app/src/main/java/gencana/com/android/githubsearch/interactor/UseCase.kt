package gencana.com.android.githubsearch.interactor

import gencana.com.android.githubsearch.common.model.Params
import io.reactivex.Single
import java.security.InvalidParameterException

abstract class  UseCase<T, P: Params>{

    protected abstract fun registerObservable(params: P): Single<T>

    fun getObservable(params: P): Single<T> {
        return if (!validateParams(params))
            Single.error(InvalidParameterException("Invalid Parameter"))
        else
            registerObservable(params)
    }

    abstract fun validateParams(params: P): Boolean

}