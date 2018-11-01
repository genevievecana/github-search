package gencana.com.android.githubsearch.common.model


data class PagingListModel<T>(
        val totalCount: Int,
        val data: List<T>
){

    fun hasNextPage(): Boolean {
        return true
    }
}