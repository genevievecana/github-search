package gencana.com.android.githubsearch.view.adapter.viewholder.creator

import android.view.View
import gencana.com.android.githubsearch.R
import gencana.com.android.githubsearch.view.adapter.RecyclerMultiAdapter
import gencana.com.android.githubsearch.view.adapter.viewholder.UserViewHolder


enum class ViewHolderEnum(val viewType: Int,
                          val layout: Int,
                          val viewHolder: (view: View) -> RecyclerMultiAdapter.BaseViewHolder<*>) {

    ITEM_USER(0, R.layout.item_user, { view: View -> UserViewHolder(view) });

    companion object {

        fun getViewHolderType(type: Int): ViewHolderEnum?{
            ViewHolderEnum.values().forEach {
                if (it.viewType == type){
                    return it
                }
            }

            return null
        }
    }
}