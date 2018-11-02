package gencana.com.android.githubsearch.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import gencana.com.android.githubsearch.view.adapter.paging.getDiffCallback

import gencana.com.android.githubsearch.view.adapter.viewholder.creator.ViewHolderEnum
import gencana.com.android.githubsearch.view.adapter.viewholder.creator.ViewHolderInterface
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


class RecyclerMultiAdapter<E: ViewHolderInterface>(
        hasClickListener: Boolean = true
)  : PagedListAdapter<E, RecyclerMultiAdapter.BaseViewHolder<E>>(getDiffCallback<E>()) {


    private val itemClickPublisher: PublishSubject<E>?
            = if (hasClickListener) PublishSubject.create() else null


    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<E> {
        val viewHolderEnum = ViewHolderEnum.getViewHolderType(viewType)
                ?: throw NullPointerException("Invalid ViewHolder Type")

        val view: View = LayoutInflater.from(parent.context)
                .inflate(viewHolderEnum.layout, parent, false)
        return viewHolderEnum.viewHolder(view) as BaseViewHolder<E>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<E>, position: Int) {
        getItem(position)?.let {holder.onBind(it, itemClickPublisher)}
    }

    internal inline fun <reified R>getClickObservable(): Observable<R>?{
        return itemClickPublisher
                ?.filter{it is R }
                ?.map { it as R }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.getViewType() ?: 0
    }

    abstract class BaseViewHolder<E : ViewHolderInterface>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun onBind(data: E, itemClickPublisher: PublishSubject<E>?)
    }

}