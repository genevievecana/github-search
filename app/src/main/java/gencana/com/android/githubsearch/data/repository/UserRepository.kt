package gencana.com.android.githubsearch.data.repository

import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.UserModel
import gencana.com.android.githubsearch.data.entity.mapToPresentation
import gencana.com.android.githubsearch.data.repository.datastore.UserDataStoreFactory
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository
@Inject constructor(
        private val dataStoreFactory: UserDataStoreFactory){

    fun searchUsers(query: String, page: Int = 1): Single<PagingListModel<UserModel>>
            = dataStoreFactory
                .create()
                .searchUsers(query, page)
                    .map {paging ->
                        paging.mapToPresentation {
                            paging.data.map {
                                it.mapToPresentation()
                        }}
                    }
}