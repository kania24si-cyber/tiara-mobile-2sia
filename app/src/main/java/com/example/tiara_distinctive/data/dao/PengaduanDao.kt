package com.example.tiara_distinctive.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tiara_distinctive.data.entity.PengaduanEntity

@Dao
interface PengaduanDao {
    @Query("SELECT * FROM pengaduan ORDER BY createdAt DESC")
    suspend fun getAll(): List<PengaduanEntity>

    @Insert
    suspend fun insert(pengaduan: PengaduanEntity)

    @Delete
    suspend fun delete(pengaduan: PengaduanEntity)
}