package gencana.com.android.githubsearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


open class TestLiveDataObserver<T> : Observer<T> {

    val observedValues = mutableListOf<T?>()

    override fun onChanged(value: T?) {
        observedValues.add(value)
    }
}

fun <T> LiveData<T>.testObserver() = TestLiveDataObserver<T>().also {
    observeForever(it)
}