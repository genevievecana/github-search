package gencana.com.android.githubsearch.data.repository.datastore

import gencana.com.android.githubsearch.data.entity.PagingList
import gencana.com.android.githubsearch.data.entity.UserData
import gencana.com.android.githubsearch.data.remote.ApiService
import io.reactivex.Single


class UserApiDataStore(private val apiService: ApiService): UserDataStore{

    override fun searchUsers(query: String, page: Int): Single<PagingList<UserData>>
            = apiService.searchUsers(query, page)

}