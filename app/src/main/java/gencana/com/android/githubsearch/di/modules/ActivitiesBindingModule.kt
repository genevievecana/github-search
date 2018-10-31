package gencana.com.android.githubsearch.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import gencana.com.android.githubsearch.MainActivity

@Module
interface ActivitiesBindingModule {

    @ContributesAndroidInjector(modules = [])
    fun mainActivity(): MainActivity

}