package com.example.moviemvvm.data.api

import android.content.SharedPreferences
import com.example.moviemvvm.utils.Constants.Companion.BASE_URL
import com.example.moviemvvm.utils.Constants.Companion.DEBUG
import com.example.moviemvvm.utils.Constants.Companion.REQUEST_TIMEOUT_DURATION
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory


object ApiClient {
    fun create(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

    fun getOkHttpClient(authInterceptor: Interceptor): OkHttpClient {
        val logginInterceptor = HttpLoggingInterceptor()
        logginInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        return builder.addInterceptor(logginInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .addInterceptor(authInterceptor)
            .build()
    }

    fun getAuthInterceptor(sharedPreferences: SharedPreferences): Interceptor {
        return Interceptor { chain ->
            val newRequest = chain.request()
                .newBuilder()
                .addHeader("Authorization", sharedPreferences.getString("token", "")!!)
                .build()

            chain.proceed(newRequest)
        }
    }

//    val instance: ApiService = Retrofit.Builder().run {
//        val gson = GsonBuilder()
//            .enableComplexMapKeySerialization()
//            .setPrettyPrinting()
//            .create()
//
//        baseUrl(BASE_URL)
//        addConverterFactory(GsonConverterFactory.create(gson))
//        client(createRequestInterceptorClient())
//        build()
//    }.create(ApiService::class.java)
//
//
//    private fun createRequestInterceptorClient(): OkHttpClient {
//        val interceptor = Interceptor { chain ->
//            val original = chain.request()
//            val requestBuilder = original.newBuilder()
//            val request = requestBuilder.build()
//            chain.proceed(request)
//        }
//
//        return if (DEBUG) {
//            OkHttpClient.Builder()
//                .addInterceptor(interceptor)
//                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                .connectTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
//                .readTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
//                .writeTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
//                .build()
//        } else {
//            OkHttpClient.Builder()
//                .addInterceptor(interceptor)
//                .connectTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
//                .readTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
//                .writeTimeout(REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
//                .build()
//        }
//    }
}