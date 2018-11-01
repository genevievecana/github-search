package gencana.com.android.githubsearch.common.extensions

import android.view.View

fun View.show(show: Boolean = true) {
    visibility = if (show) View.VISIBLE else View.GONE
}

fun View.invisible(invisible: Boolean = true) {
    visibility = if (invisible) View.INVISIBLE else View.VISIBLE
}

fun View.isVisible(): Boolean
        = visibility == View.VISIBLE