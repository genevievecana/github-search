package gencana.com.android.githubsearch.view.custom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes


interface BaseView<T> {

    @LayoutRes
    fun getLayout(): Int

    fun setupView(viewGroup: ViewGroup): View {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(getLayout(), viewGroup, true)
        postSetup(view)
        return view
    }

    fun postSetup(view: View){

    }

    fun onBind(data: T){

    }

}