package gencana.com.android.githubsearch.view.adapter.paging

interface PagingData<T>{

    val list: List<T>?

    fun hasNextPage(): Boolean
}
