package com.example.tiara_distinctive.Pengaduan

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.tiara_distinctive.R
import com.example.tiara_distinctive.data.AppDatabase
import com.example.tiara_distinctive.data.entity.PengaduanEntity
import com.example.tiara_distinctive.databinding.ActivityPengaduanFormBinding
import kotlinx.coroutines.launch

class PengaduanFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPengaduanFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPengaduanFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        binding.btnSavePengaduan.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val content = binding.etContent.text.toString()

            if (title.isNotBlank() && content.isNotBlank()) {
                lifecycleScope.launch {
                    val pengaduan = PengaduanEntity(
                        title = title,
                        content = content,
                        createdAt = System.currentTimeMillis()
                    )
                    db.pengaduanDao().insert(pengaduan)
                    finish()
                }
            } else {
                Toast.makeText(this, "Semua data wajib diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}