package com.example.tolonginapp.tolongin.deps

import com.example.tolonginapp.tolongin.BuildConfig
import com.example.tolonginapp.tolongin.network.NetworkManager
import com.example.tolonginapp.tolongin.network.NetworkService
import com.example.tolonginapp.tolongin.utils.Constant.BaseUrl.Companion.BASE_URL
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    private val REQUEST_TIMEOUT = 10


    @Provides
    @Singleton
    fun providesGson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        .create()

    @Provides
    @Singleton
    fun providesNetworkService(retrofit: Retrofit): NetworkService = retrofit.create(NetworkService::class.java)

    @Singleton
    @Provides
    fun providesNetworkManager(service: NetworkService) = NetworkManager(service)

    @Provides
    @Singleton
    fun providesLoggingInterceptor() = HttpLoggingInterceptor()
        .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

    @Provides
    @Singleton
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
        .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
        .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient, gson: Gson) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
}