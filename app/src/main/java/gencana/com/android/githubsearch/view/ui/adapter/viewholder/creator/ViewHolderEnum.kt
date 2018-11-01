package gencana.com.android.githubsearch.view.ui.adapter.viewholder.creator

import android.view.View
import gencana.com.android.githubsearch.view.ui.adapter.RecyclerMultiAdapter


enum class ViewHolderEnum(val viewType: Int,
                          val layout: Int,
                          val viewHolder: (view: View) -> RecyclerMultiAdapter.BaseViewHolder<*>) {

    ;

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