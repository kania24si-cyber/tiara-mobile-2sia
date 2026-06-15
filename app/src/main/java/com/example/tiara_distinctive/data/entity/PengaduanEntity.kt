package com.example.tiara_distinctive.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pengaduan")
data class PengaduanEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val createdAt: Long
)