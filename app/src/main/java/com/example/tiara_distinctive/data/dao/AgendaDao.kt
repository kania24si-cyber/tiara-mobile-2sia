package com.example.tiara_distinctive.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tiara_distinctive.data.entity.AgendaEntity

@Dao
interface AgendaDao {
    @Query("SELECT * FROM agenda ORDER BY createdAt DESC")
    suspend fun getAll(): List<AgendaEntity>

    @Insert
    suspend fun insert(agenda: AgendaEntity)

    @Delete
    suspend fun delete(agenda: AgendaEntity)
}