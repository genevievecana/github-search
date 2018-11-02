package gencana.com.android.githubsearch.common.application

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import gencana.com.android.githubsearch.common.utils.IMAGE_RADIUS

@GlideModule
class MyGlideModule: AppGlideModule(){
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setDefaultRequestOptions(getDefaultRequestOptions())
    }


    private fun getDefaultRequestOptions(): RequestOptions
            = RequestOptions()
            .transforms(CenterCrop(), RoundedCorners(IMAGE_RADIUS))

}