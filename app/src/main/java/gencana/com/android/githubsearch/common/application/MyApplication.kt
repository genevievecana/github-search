package gencana.com.android.githubsearch.common.application

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import gencana.com.android.githubsearch.di.components.DaggerAppComponent


class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .create(this)
                .build()
    }
}