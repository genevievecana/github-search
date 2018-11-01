package gencana.com.android.githubsearch.di.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import gencana.com.android.githubsearch.common.viewmodel.ViewModelFactory

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}