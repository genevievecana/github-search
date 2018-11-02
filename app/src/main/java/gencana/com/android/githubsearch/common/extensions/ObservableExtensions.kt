package gencana.com.android.githubsearch.common.extensions

import gencana.com.android.githubsearch.common.model.ResultEvent
import io.reactivex.Observable

fun Observable<ResultEvent>.addErrorHandler(): Observable<ResultEvent> {
    return onErrorResumeNext{throwable: Throwable ->
        map {
            ResultEvent.OnError(throwable)
        }}
}

fun <T>switchMapError(single: Observable<T>): Observable<ResultEvent>{
    return single.map {
        ResultEvent.OnSuccess(it) as ResultEvent
    }.apply {
        onErrorResumeNext{throwable: Throwable ->
            map {
                ResultEvent.OnError(throwable)
            }}
    }
}