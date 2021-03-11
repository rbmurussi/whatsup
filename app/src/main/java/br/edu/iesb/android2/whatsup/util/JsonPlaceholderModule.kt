package br.edu.iesb.android2.whatsup.util

import com.google.gson.GsonBuilder
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//@Module
//@InstallIn(SingletonComponent::class)
class JsonPlaceholderModule {

//    @Provides
    fun createRetrofit(): Retrofit {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()

        val gsonConfig = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()

        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gsonConfig))
            .build()
    }

//    @Provides
    fun provideEndpoint(retrofit: Retrofit) : Endpoint {
        return retrofit.create(Endpoint::class.java)
    }
}