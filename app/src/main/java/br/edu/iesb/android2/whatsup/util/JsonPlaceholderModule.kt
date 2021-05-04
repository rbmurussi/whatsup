package br.edu.iesb.android2.whatsup.util

import br.edu.iesb.android2.whatsup.service.JsonPlaceholderService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class JsonPlaceholderModule {

    @Provides
    fun createRetrofit(): Retrofit {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(logInterceptor).build()

        return Retrofit.Builder()
                .client(client)
                .baseUrl("https://dflowapp.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    fun provideEndpoint(retrofit: Retrofit) : JsonPlaceholderService {
        return retrofit.create(JsonPlaceholderService::class.java)
    }
}