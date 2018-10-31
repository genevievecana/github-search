package gencana.com.android.githubsearch.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import gencana.com.android.githubsearch.common.utils.SHARED_PREF_NAME
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app : Application) : Context = app

    @Provides
    @Singleton
    fun provideIoScheduler() : Scheduler = Schedulers.io()

    @Provides
    @Singleton
    fun provideSharedPreference(app: Application): SharedPreferences
            = app.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
}