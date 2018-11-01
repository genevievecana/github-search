package gencana.com.android.githubsearch.data.remote.paging

interface PagingData<T>{

    val list: List<T>?

    fun hasNextPage(): Boolean
}
