package gencana.com.android.githubsearch.view.adapter.paging

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by Gen Cana on 01/11/2018
 */


fun <E>getDiffCallback()
        = object : DiffUtil.ItemCallback<E>() {
                override fun areItemsTheSame(oldItem: E, newItem: E): Boolean {
                    return oldItem.toString() == newItem.toString()
                }

                override fun areContentsTheSame(oldItem: E, newItem: E): Boolean {
                    return oldItem == newItem
                }

            }