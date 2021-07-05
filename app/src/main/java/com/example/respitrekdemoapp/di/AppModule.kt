package com.example.respitrekdemoapp.di

import com.example.respitrekdemoapp.network.AuthApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://simplifiedcoding.tech/mywebapp/public/api/")
                .client(
                        OkHttpClient.Builder().also {
                            val logging=HttpLoggingInterceptor()

                           logging.setLevel(HttpLoggingInterceptor.Level.BODY )
                            it.addInterceptor(logging)
                        }.build()
                )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    @Provides
    @Singleton
    fun provideUnsplashApi(retrofit: Retrofit):AuthApi=
        retrofit.create(AuthApi::class.java)
}