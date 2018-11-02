package gencana.com.android.githubsearch.interactor

import gencana.com.android.githubsearch.BaseTestClass
import gencana.com.android.githubsearch.common.model.PagingListModel
import gencana.com.android.githubsearch.common.model.SearchParams
import gencana.com.android.githubsearch.common.model.UserModel
import gencana.com.android.githubsearch.data.repository.UserRepository
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.security.InvalidParameterException


@RunWith(MockitoJUnitRunner::class)
class UserInteractorTest: BaseTestClass() {

    @Mock
    private lateinit var repository: UserRepository

    private var params = SearchParams("abc", 1)

    @Mock
    private lateinit var userListResults: PagingListModel<UserModel>

    private lateinit var interactor: UserInteractor

    private val testObserver by lazy {
        TestObserver<PagingListModel<UserModel>>()
    }

    override fun setup() {
        interactor = UserInteractor(repository)
    }


    @Test
    fun `test valid usecase`() {
        Mockito.`when`(repository.searchUsers(params.query, params.page))
                .thenReturn(Single.just(userListResults))

        interactor.getObservable(params)
                .subscribe(testObserver)

        assertBuilder.that(testObserver.assertValue{
            it == userListResults
        })

        assertBuilder.that(testObserver.assertComplete())

        Mockito.verify(repository)
                .searchUsers(anyString(), anyInt())

        Mockito.verifyNoMoreInteractions(repository)
    }

    @Test
    fun `test throw invalidparameter`() {
        params.query = ""
        interactor.getObservable(params).subscribe(testObserver)
        assertBuilder.that(testObserver.assertError(InvalidParameterException::class.java))
    }

    @Test
    fun `test valid params`() {
        var isValid =  interactor.validateParams(params)
        assertBuilder.that(isValid).isTrue()
    }

    @Test
    fun `test invalid params`() {
        params.query = ""
        assertBuilder.that(interactor.validateParams(params)).isFalse()
    }

}