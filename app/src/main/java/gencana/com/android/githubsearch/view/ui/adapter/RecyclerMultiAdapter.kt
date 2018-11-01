package gencana.com.android.githubsearch.view.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gencana.com.android.githubsearch.view.ui.adapter.viewholder.creator.ViewHolderEnum
import gencana.com.android.githubsearch.view.ui.adapter.viewholder.creator.ViewHolderInterface
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


class RecyclerMultiAdapter<E: ViewHolderInterface>(
        private val itemList: MutableList<E>,
        private val itemClickPublisher: PublishSubject<E>?
) : RecyclerView.Adapter<RecyclerMultiAdapter.BaseViewHolder<E>>() {

    override fun getItemCount(): Int {
        return itemList.size
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<E> {
        val viewHolderEnum = ViewHolderEnum.getViewHolderType(viewType)
                ?: throw NullPointerException("Invalid ViewHolder Type")

        val view: View = LayoutInflater.from(parent.context)
                .inflate(viewHolderEnum.layout, parent, false)
        return viewHolderEnum.viewHolder(view) as BaseViewHolder<E>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<E>, position: Int) {
        holder.onBind(itemList[position], itemClickPublisher)
    }

    internal inline fun <reified R>getClickObservable(): Observable<R>?{
        return itemClickPublisher
                ?.filter{it is R }
                ?.map { it as R }
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].getViewType()
    }

    //TODO: replace paging
    fun addItem(item: E, isClear: Boolean = true){
        if (isClear) {
            itemList.clear()
        }
        itemList.add(item)
        notifyDataSetChanged()
    }

    //TODO: replace paging
    fun addItems(items: List<E>, isClear: Boolean = true){
        if (isClear) {
            itemList.clear()
        }
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder<E : ViewHolderInterface>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun onBind(data: E, itemClickPublisher: PublishSubject<E>?)
    }

}