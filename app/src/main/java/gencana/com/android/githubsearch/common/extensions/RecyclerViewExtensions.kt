package gencana.com.android.githubsearch.common.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gencana.com.android.githubsearch.view.ui.adapter.RecyclerMultiAdapter
import gencana.com.android.githubsearch.view.ui.adapter.viewholder.creator.ViewHolderInterface

fun <E: ViewHolderInterface> RecyclerView.defaultMultiAdapter(
        hasClickListener: Boolean = true,
        layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
): RecyclerMultiAdapter<E> {

    setLayoutManager(layoutManager)
    val multiAdapter = RecyclerMultiAdapter<E>(hasClickListener)
    adapter = multiAdapter
    return multiAdapter
}