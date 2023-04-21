package kong.droid.test.di

import android.content.Context
import dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kong.droid.test.api.APIService
import kong.droid.test.viewmodel.MainRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Provides
    @Singleton
    fun provideAPIService(@ApplicationContext context: Context): APIService {
        return Retrofit.Builder()
            .baseUrl("https://api.itbook.store/1.0/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
            .create(APIService::class.java)
    }

    @Provides
    @Singleton
    fun provideMainRepository(apiService: APIService) = MainRepository(apiService)
}