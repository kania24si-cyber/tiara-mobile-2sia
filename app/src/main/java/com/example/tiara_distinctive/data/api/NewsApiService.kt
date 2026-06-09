package com.example.tiara_distinctive.data.api

import com.example.tiara_distinctive.data.model.NewsResponse
import retrofit2.http.GET

interface NewsApiService {

    // Mengosongkan string GET karena BASE_URL sudah lengkap,
    // atau gunakan @GET(".") jika Retrofit versi lama meminta path
    @GET("./")
    suspend fun getNews(): NewsResponse

}