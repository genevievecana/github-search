package gencana.com.android.githubsearch.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import gencana.com.android.githubsearch.di.modules.NetworkModule
import gencana.com.android.githubsearch.di.modules.RepositoryModule
import gencana.com.android.githubsearch.di.modules.ActivitiesBindingModule
import gencana.com.android.githubsearch.di.modules.AppModule
import gencana.com.android.githubsearch.di.modules.MockModule
import gencana.com.android.githubsearch.common.application.MyApplication
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivitiesBindingModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    MockModule::class
])

interface AppComponent: AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }
}