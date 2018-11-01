package gencana.com.android.githubsearch.common.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


inline fun <T> LiveData<T>.addObserver(owner: LifecycleOwner, crossinline t: (T)-> Unit){
    observe(owner, Observer {
        it?.let { it1 -> t.invoke(it1) }
    })
}