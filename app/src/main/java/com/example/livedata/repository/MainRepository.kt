package com.example.livedata.repository

import androidx.lifecycle.MutableLiveData
import com.example.livedata.LatestNewsResponse

class MainRepository {
    fun fetchDataFromNetwork(): MutableLiveData<LatestNewsResponse>{

        val networkData = NetworkDataSource().retrieveData()

        return networkData
    }
}