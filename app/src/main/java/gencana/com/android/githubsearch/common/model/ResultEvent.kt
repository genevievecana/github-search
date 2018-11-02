package gencana.com.android.githubsearch.common.model


sealed class ResultEvent{

    data class OnSuccess<T>(val data: T) : ResultEvent()

    object OnEmptyResults : ResultEvent()

    data class OnStart(val isPaging: Boolean = false) : ResultEvent()

    data class  OnFinish(val isPaging: Boolean = false) : ResultEvent()

    data class OnExpectedError(val errorEnum: ErrorEnum, val isPaging: Boolean = false) : ResultEvent()

    data class OnError(val throwable: Throwable) : ResultEvent()
}