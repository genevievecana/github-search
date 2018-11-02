package gencana.com.android.githubsearch.view.ui.main

import gencana.com.android.githubsearch.BaseTestClass
import gencana.com.android.githubsearch.TestLiveDataObserver
import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.ResultEvent
import gencana.com.android.githubsearch.common.model.SearchParams
import gencana.com.android.githubsearch.common.model.UserModel
import gencana.com.android.githubsearch.interactor.UserInteractor
import gencana.com.android.githubsearch.testObserver
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock


class MainViewModelTest: BaseTestClass(){

    @Mock
    private lateinit var interactor: UserInteractor


    private lateinit var mainViewModel: MainViewModel

    private lateinit var liveDataLoading: TestLiveDataObserver<ResultEvent>


    override fun setup() {
        mainViewModel = MainViewModel(interactor, Schedulers.trampoline())
    }

    @Test
    fun loadingStates() {
        val params = SearchParams("Gen", 1)
        val userModel = mock(UserModel::class.java)
        val response: PagingListModel<UserModel> = PagingListModel(100, listOf(userModel, userModel))
        liveDataLoading = mainViewModel.resultStateLiveData.testObserver()

        Mockito.`when`(interactor.getObservable(params))
                .thenReturn(Single.just(response))

        mainViewModel.executePaging(params)

        assertBuilder
                .that(liveDataLoading.observedValues.size)
                .isEqualTo(2)

        Mockito.verify(interactor)
                .getObservable(params)

        Mockito.verifyNoMoreInteractions(interactor)
    }

}