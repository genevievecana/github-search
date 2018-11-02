package gencana.com.android.githubsearch.view.ui.main

import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.SearchParams
import gencana.com.android.githubsearch.common.model.UserModel
import gencana.com.android.githubsearch.interactor.UserInteractor
import gencana.com.android.githubsearch.view.ui.base.BasePagingViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject


class MainViewModel @Inject constructor(
        private val userInteractor: UserInteractor,
        io: Scheduler
): BasePagingViewModel<PagingListModel<UserModel>, UserModel, SearchParams>(io) {

    override fun getObservable(params: SearchParams): Observable<PagingListModel<UserModel>>
            = userInteractor.getObservable(params).toObservable()

    override fun getPagedObservable(params: SearchParams): (page: Int) -> Observable<PagingListModel<UserModel>>{
        return { page: Int ->
            params.page = page
            getObservable(params)
        }
    }

}