package com.example.tiara_distinctive.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tiara_distinctive.data.dao.AgendaDao
import com.example.tiara_distinctive.data.dao.PengaduanDao
import com.example.tiara_distinctive.data.entity.AgendaEntity
import com.example.tiara_distinctive.data.entity.PengaduanEntity

@Database(
    entities = [PengaduanEntity::class, AgendaEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pengaduanDao(): PengaduanDao
    abstract fun agendaDao(): AgendaDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration() // Menghindari crash jika struktur tabel berubah
                    .build().also { INSTANCE = it }
            }
        }
    }
}