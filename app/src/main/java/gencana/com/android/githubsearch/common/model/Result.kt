package gencana.com.android.githubsearch.common.model

data class Result<T>(
        var data: T? = null,
        val error: String? = null
){

    fun hasError(): Boolean{
        return error != null
    }
}