package com.example.livedata

data class LatestNewsResponse (

    val news: List<New>,
    val page: Int,
    val status : String

)

data class New(

    val author: String,
    val category: List<String>,
    val description: String,
    val id: String,
    val image: String,
    val language: String,
    val published: String,
    val title: String,
    val url: String


        )


