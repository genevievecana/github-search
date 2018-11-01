package gencana.com.android.githubsearch.common.extensions

import gencana.com.android.githubsearch.common.model.Result
import io.reactivex.Observable

fun <T> Observable<Result<T>>.addErrorHandler(): Observable<Result<T>> {
    return onErrorResumeNext{throwable: Throwable ->
        Observable.just(Result(error = throwable.message)) }
}