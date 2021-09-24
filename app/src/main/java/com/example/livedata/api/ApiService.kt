package com.example.livedata.api

import android.telecom.Call
import com.example.livedata.LatestNewsResponse
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Headers




interface ApiService {

    @GET("latest-news")
    fun getLatestNews(@HeaderMap hashMap: HashMap<String, String>): retrofit2.Call<LatestNewsResponse>
}