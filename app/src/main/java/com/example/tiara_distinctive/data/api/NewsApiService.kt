package com.example.tiara_distinctive.data.api

import com.example.tiara_distinctive.data.model.NewsResponse
import retrofit2.http.GET

interface NewsApiService {
    @GET("./")
    suspend fun getNews(): NewsResponse

}