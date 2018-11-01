package gencana.com.android.githubsearch.data.repository.datastore

import com.squareup.moshi.Moshi
import gencana.com.android.githubsearch.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Named

class UserDataStoreFactory
@Inject constructor(
        private val moshi: Moshi,
        private val apiService: ApiService,
        @Named("IS_MOCK") private val isMock: Boolean
){

    fun create(mock: Boolean = isMock): UserDataStore{
        return if (mock){
            MockDataStore(moshi)
        }else{
            UserApiDataStore(apiService)
        }
    }
}

