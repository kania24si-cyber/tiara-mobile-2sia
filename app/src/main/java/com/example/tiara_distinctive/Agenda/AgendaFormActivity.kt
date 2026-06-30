package com.example.tiara_distinctive.Agenda

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.tiara_distinctive.BaseActivity
import com.example.tiara_distinctive.data.AppDatabase
import com.example.tiara_distinctive.data.entity.AgendaEntity
import com.example.tiara_distinctive.databinding.ActivityAgendaFormBinding
import com.example.tiara_distinctive.utils.ReminderHelper
import kotlinx.coroutines.launch
import java.util.Calendar

class AgendaFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        binding.btnSaveAgenda.setOnClickListener {

            val nama = binding.etNamaKegiatan.text.toString()
            val lokasi = binding.etLokasi.text.toString()

            if (nama.isNotBlank() && lokasi.isNotBlank()) {

                lifecycleScope.launch {

                    val agenda = AgendaEntity(
                        namaKegiatan = nama,
                        lokasi = lokasi,
                        createdAt = System.currentTimeMillis()
                    )

                    // Simpan ke Room
                    db.agendaDao().insert(agenda)

                    // Mengambil nilai reminder berdasarkan pilihan Spinner user
                    val reminder = when(binding.spReminder.selectedItemPosition){
                        0 -> 5
                        1 -> 10
                        2 -> 15
                        else -> 30
                    }

                    // Set calendar berdasarkan durasi menit yang dipilih
                    val calendar = Calendar.getInstance()
                    calendar.add(Calendar.MINUTE, reminder)

                    // Set reminder dinamis
                    ReminderHelper.setReminder(
                        context = this@AgendaFormActivity,
                        hour = calendar.get(Calendar.HOUR_OF_DAY),
                        minute = calendar.get(Calendar.MINUTE),
                        title = "Agenda Desa",
                        message = "$nama dimulai $reminder menit lagi.",
                        targetActivity = AgendaFormActivity::class.java
                    )

                    // Toast baru sesuai instruksi
                    Toast.makeText(
                        this@AgendaFormActivity,
                        "Reminder $reminder menit berhasil dibuat",
                        Toast.LENGTH_SHORT
                    ).show()

                    finish()
                }

            } else {
                Toast.makeText(
                    this,
                    "Isi Nama Kegiatan & Lokasi!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}