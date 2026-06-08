package com.example.tiara_distinctive.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsApiClient {

    private const val BASE_URL =
        "https://jsonplaceholder.typicode.com/"

    val apiService: NewsApiService by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(NewsApiService::class.java)

    }
}