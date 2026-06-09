package com.example.tiara_distinctive.data.model

import com.google.gson.annotations.SerializedName

// 1. Tambahkan class pembungkus karena JSON-nya diawali dengan objek {} bukan langsung array []
data class NewsResponse(
    val results: List<NewsModel>
)

data class NewsModel(
    val id: Int,
    val title: String,
    val summary: String,

    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("news_site")
    val newsSite: String
)