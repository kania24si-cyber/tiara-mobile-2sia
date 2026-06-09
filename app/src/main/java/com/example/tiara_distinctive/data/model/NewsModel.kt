package com.example.tiara_distinctive.data.model

import com.google.gson.annotations.SerializedName

// 1. Tambahkan class pembungkus karena JSON-nya diawali dengan objek {} bukan langsung array []
data class NewsResponse(
    @SerializedName("results")
    val results: List<NewsModel>
)

// 2. Sesuaikan properti dengan JSON asli Spaceflight
data class NewsModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("summary") // Mengganti body menjadi summary
    val summary: String,
    @SerializedName("image_url") // Tambahan jika nanti ingin menampilkan gambar
    val imageUrl: String,
    @SerializedName("news_site")
    val newsSite: String
)