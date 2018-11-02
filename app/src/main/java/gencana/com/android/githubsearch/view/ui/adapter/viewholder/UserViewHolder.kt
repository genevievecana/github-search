package gencana.com.android.githubsearch.view.ui.adapter.viewholder

import android.view.View
import com.bumptech.glide.Glide
import gencana.com.android.githubsearch.common.application.GlideApp
import gencana.com.android.githubsearch.common.model.UserModel
import gencana.com.android.githubsearch.view.ui.adapter.RecyclerMultiAdapter
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_user.view.*

class UserViewHolder(view: View): RecyclerMultiAdapter.BaseViewHolder<UserModel>(view){

    override fun onBind(data: UserModel, itemClickPublisher: PublishSubject<UserModel>?) {
        GlideApp.with(itemView.context).load(data.avatarUrl).into(itemView.img_avatar)
        itemView.txt_username.text = data.username
        itemView.txt_rating.text = data.score.toInt().toString()

    }
}