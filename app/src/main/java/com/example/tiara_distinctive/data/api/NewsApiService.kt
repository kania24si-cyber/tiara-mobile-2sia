package com.example.tiara_distinctive.data.api

import com.example.tiara_distinctive.data.model.NewsModel
import retrofit2.http.GET

interface NewsApiService {

    @GET("posts")
    suspend fun getNews(): List<NewsModel>

}