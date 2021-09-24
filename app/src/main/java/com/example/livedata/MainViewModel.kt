package com.example.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livedata.repository.MainRepository

class MainViewModel: ViewModel() {


    fun emitValue() = MainRepository().fetchDataFromNetwork()
}