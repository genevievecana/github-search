package gencana.com.android.githubsearch.di.modules

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import gencana.com.android.githubsearch.data.remote.adapter.ApplicationJsonAdapterFactory
import gencana.com.android.githubsearch.BuildConfig
import gencana.com.android.githubsearch.data.remote.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(

    ): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()

        if (BuildConfig.DEBUG){
            okHttpClient.addInterceptor(HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun providesAdapterFactory(): RxJava2CallAdapterFactory
            = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun providesMoshi(): Moshi
            = Moshi.Builder()
                .add(ApplicationJsonAdapterFactory.INSTANCE)
                .build()

    @Provides
    @Singleton
    fun providesConverterFactory(moshi: Moshi): Converter.Factory
            = MoshiConverterFactory.create(moshi)

    @Provides
    @Singleton
    fun providesRetrofit(
            converterFactory: Converter.Factory,
            rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
            okHttpClient: OkHttpClient
    ): Retrofit
            = Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun providesApiService(
            retrofit: Retrofit
    ): ApiService{
        return retrofit.create(ApiService::class.java)
    }

}