package gencana.com.android.githubsearch.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import gencana.com.android.githubsearch.R
import gencana.com.android.githubsearch.common.extensions.invisible
import gencana.com.android.githubsearch.common.extensions.show
import kotlinx.android.synthetic.main.view_placeholder.view.*


class PlaceHolderView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), BaseView<Nothing> {

    private var view: View = setupView(this)
    private var mainView: View? = null

    fun setup(view: View, placeholderText: String? = null){
        setMainView(view)
        showEmpty(placeholderText)
    }

    fun setMainView(view: View){
        mainView = view
    }

    fun setImageActionListener(clickAction: () -> Unit) {
        view.img_retry.setOnClickListener {
            clickAction.invoke() }
    }

    fun showLoading(show: Boolean){
        view.apply {
            img_retry.show(false)
            progress_bar.show(show)
        }
        show()
    }

    fun showEmpty(message: String?){
        mainView?.invisible()
        show()
        view.apply {
            img_retry.show(false)
            txt_placeholder.apply {
                text = message ?: context.getString(R.string.error_empty)
                show()
            }
        }
    }

    fun showError(message: String?){
        mainView?.invisible()
        show()
        view.apply {
            txt_placeholder.apply {
                text = message ?: context.getString(R.string.error_default)
                show()
            }
            img_retry.show()
        }
    }

    fun hideError(){
        mainView?.show()
        show(false)
        view.apply {
            img_retry.show(false)
            txt_placeholder.apply {
                text = ""
                invisible(false)
            }
        }
    }

    override fun getLayout(): Int = R.layout.view_placeholder

}