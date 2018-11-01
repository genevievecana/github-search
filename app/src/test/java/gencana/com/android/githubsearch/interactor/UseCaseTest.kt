package gencana.com.android.githubsearch.interactor

import gencana.com.android.githubsearch.BaseTestClass
import gencana.com.android.githubsearch.common.model.SearchParams
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Test
import java.security.InvalidParameterException


class UseCaseTest: BaseTestClass(){

    private lateinit var useCase: UseCaseClass

    override
    fun setup(){
        useCase = UseCaseClass()
    }

    @Test
    fun `test valid usecase`() {
        val testObserver = TestObserver<String>()
        useCase.getObservable(SearchParams("abc"))
                .subscribe(testObserver)

        assertBuilder.that(testObserver.assertResult(TEST_STRING))
    }

    @Test
    fun `test invalid usecase`() {
        val testObserver = TestObserver<String>()
        useCase.getObservable(SearchParams("")).subscribe(testObserver)
        assertBuilder.that(testObserver.assertError(InvalidParameterException::class.java))
    }

    @Test
    fun `test valid params`() {
        val isValid = useCase.validateParams(SearchParams("name"))
        assertBuilder.that(isValid).isTrue()
    }

    @Test
    fun `test invalid params`() {
        val isValid = useCase.validateParams(SearchParams(""))
        assertBuilder.that(isValid).isFalse()
    }

    private class UseCaseClass
        : UseCase<String, SearchParams>(){
        override fun validateParams(params: SearchParams): Boolean {
            return !params.query.isEmpty()
        }

        override fun registerObservable(params: SearchParams): Single<String> {
            return Single.just(TEST_STRING)
        }
    }


}