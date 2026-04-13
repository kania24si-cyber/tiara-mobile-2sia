package com.example.tiara_distinctive.pertemuan_3_laporan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tiara_distinctive.databinding.ActivityWelcomeBinding
import com.example.tiara_distinctive.pertemuan_2_laporan.HitungActivity
import com.example.tiara_distinctive.pertemuan_4_laporan.Custom1Activity
import com.example.tiara_distinctive.pertemuan_4_laporan.Custom2Activity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME")
        binding.textUsername.text = "Halo, $username 👋"

        binding.btnRumus.setOnClickListener {
            val intent = Intent(this, HitungActivity::class.java)
            intent.putExtra("judul", "Menghitung Luas Segitiga dan Volume Kubus")
            intent.putExtra("deskripsi", "Halaman Hitung Rumus Bangun Ruang")
            startActivity(intent)
        }

        binding.btnCustom1.setOnClickListener {
            val intent = Intent(this, Custom1Activity::class.java)
            intent.putExtra("judul", "Custom 1")
            intent.putExtra("deskripsi", "Halaman Custom 1 berisi\n" + "gambar dan text")
            startActivity(intent)
        }

        binding.btnCustom2.setOnClickListener {
            val intent = Intent(this, Custom2Activity::class.java)
            intent.putExtra("judul", "Custom 2")
            intent.putExtra("deskripsi", "Halaman Custom 2 berisi\n" + "gambar dan text")
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                .setNegativeButton("Tidak") { _, _ ->
                    com.google.android.material.snackbar.Snackbar
                        .make(binding.root, "Logout dibatalkan", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT)
                        .show()
                }
                .show()
        }
    }
}