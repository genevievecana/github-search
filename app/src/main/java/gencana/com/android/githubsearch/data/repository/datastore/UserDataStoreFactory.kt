package gencana.com.android.githubsearch.data.repository.datastore

import gencana.com.android.githubsearch.data.remote.ApiService
import javax.inject.Inject

class UserDataStoreFactory
@Inject constructor(
        private val apiService: ApiService){

    fun create(): UserDataStore{
        return UserApiDataStore(apiService)
    }
}

