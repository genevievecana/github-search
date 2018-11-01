package gencana.com.android.githubsearch.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import gencana.com.android.githubsearch.common.viewmodel.ViewModelFactory
import gencana.com.android.githubsearch.common.viewmodel.ViewModelKey
import gencana.com.android.githubsearch.view.ui.main.MainViewModel

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}