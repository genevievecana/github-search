package gencana.com.android.githubsearch.data.repository.datastore

import gencana.com.android.githubsearch.data.entity.PagingList
import gencana.com.android.githubsearch.data.entity.UserData
import io.reactivex.Single


interface UserDataStore {

    fun searchUsers(query: String, page: Int = 1): Single<PagingList<UserData>>

}