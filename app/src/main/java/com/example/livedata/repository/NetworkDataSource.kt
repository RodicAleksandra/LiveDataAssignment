package com.example.livedata.repository

import android.telecom.Call
import androidx.lifecycle.MutableLiveData
import com.example.livedata.LatestNewsResponse
import com.example.livedata.api.ApiClient
import com.example.livedata.api.Constants
import okhttp3.Response

import retrofit2.Callback

class NetworkDataSource {

    fun retrieveData(): MutableLiveData<LatestNewsResponse> {

        val headers = HashMap<String, String>()
        headers["Authorization"] = Constants.TOKEN

        val call = ApiClient.apiService.getLatestNews(headers)
        var liveData: MutableLiveData<LatestNewsResponse> = MutableLiveData()

        call.enqueue(object : Callback<LatestNewsResponse> {

            override fun onResponse(
                call: retrofit2.Call<LatestNewsResponse>,
                response: retrofit2.Response<LatestNewsResponse>
            ) {
                liveData.value=response.body()
            }

            override fun onFailure(call: retrofit2.Call<LatestNewsResponse>, t: Throwable) {
                t.printStackTrace()
            }


        })
        return liveData
    }}