package com.example.livedata.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val currentRequest = chain.request().newBuilder()

        currentRequest.addHeader("Authorization", Constants.TOKEN)

        val newRequest = currentRequest.build()

        return chain.proceed(newRequest)
    }
}