package gencana.com.android.githubsearch.data.entity

import com.squareup.moshi.Json
import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.view.adapter.paging.PagingData
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class PagingList<T>(
        @Json(name = "total_count") val totalCount: Int,
        @Json(name = "items") val data: List<T>
): PagingData<T>{

    override val list: List<T>?
        get() = data

    override fun hasNextPage(): Boolean{
        return  true
    }
}

inline fun<T, R> PagingList<T>.mapToPresentation(dataList: () -> List<R>): PagingListModel<R>
        = PagingListModel(totalCount, dataList.invoke())


