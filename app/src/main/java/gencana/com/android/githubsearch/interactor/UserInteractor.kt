package gencana.com.android.githubsearch.interactor

import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.SearchParams
import gencana.com.android.githubsearch.common.model.UserModel
import gencana.com.android.githubsearch.data.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject


class UserInteractor
@Inject constructor(
        private val repository: UserRepository
): UseCase<PagingListModel<UserModel>, SearchParams>(){

    override fun registerObservable(params: SearchParams): Single<PagingListModel<UserModel>>
            = repository.searchUsers(params.query, params.page)

    override fun validateParams(params: SearchParams): Boolean
            = !params.query.isEmpty()

}
