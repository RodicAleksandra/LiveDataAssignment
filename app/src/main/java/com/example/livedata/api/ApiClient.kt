package com.example.livedata.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val myRetrofit: Retrofit by lazy {
        val loggingInterceptor = HttpLoggingInterceptor().apply { level =
            HttpLoggingInterceptor.Level.BODY
        }

        val authInterceptor = AuthInterceptor()

        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

        val r = Retrofit.Builder()
            .baseUrl("https://api.currentsapi.services/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        r
    }

    val apiService: ApiService by lazy {
        myRetrofit.create(ApiService::class.java)
    }

}
