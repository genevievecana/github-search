package gencana.com.android.githubsearch.common.model

import gencana.com.android.githubsearch.view.adapter.viewholder.creator.ViewHolderEnum
import gencana.com.android.githubsearch.view.adapter.viewholder.creator.ViewHolderInterface

data class UserModel(
        val username: String,
        val avatarUrl: String,
        val score: Double
): ViewHolderInterface {

    override fun getViewType(): Int
            = ViewHolderEnum.ITEM_USER.viewType

    override fun toString(): String {
        return username
    }
}