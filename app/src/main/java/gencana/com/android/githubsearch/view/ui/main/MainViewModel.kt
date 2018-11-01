package gencana.com.android.githubsearch.view.ui.main

import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.Result
import gencana.com.android.githubsearch.common.model.SearchParams
import gencana.com.android.githubsearch.common.model.UserModel
import gencana.com.android.githubsearch.interactor.UserInteractor
import gencana.com.android.githubsearch.view.ui.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject


class MainViewModel @Inject constructor(
        private val airportListDetailsInteractor: UserInteractor,
        io: Scheduler
): BaseViewModel<PagingListModel<UserModel>, SearchParams>(io) {

    override fun getObservable(params: SearchParams): Observable<Result<PagingListModel<UserModel>>> {
        return airportListDetailsInteractor
                .getObservable(params)
                .toObservable()
                .map { Result(it) }
    }

}