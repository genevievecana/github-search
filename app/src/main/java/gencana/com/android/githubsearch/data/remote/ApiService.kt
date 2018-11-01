package gencana.com.android.githubsearch.data.remote

import gencana.com.android.githubsearch.common.utils.ENDPOINT_SEARCH
import gencana.com.android.githubsearch.data.entity.PagingList
import gencana.com.android.githubsearch.data.entity.UserData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{

    @GET(ENDPOINT_SEARCH)
    fun searchUsers(
            @Query("q")query: String,
            @Query("page") page: Int = 1
    ): Single<PagingList<UserData>>
}