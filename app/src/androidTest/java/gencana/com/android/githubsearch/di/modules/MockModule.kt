package gencana.com.android.githubsearch.di.modules

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MockModule{

    @Provides
    @Named("IS_MOCK")
    fun providesMockOnly(): Boolean {
        return true
    }

}