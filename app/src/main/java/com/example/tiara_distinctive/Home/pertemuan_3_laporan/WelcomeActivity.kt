package com.example.tiara_distinctive.Home.pertemuan_3_laporan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tiara_distinctive.databinding.ActivityWelcomeBinding
import com.example.tiara_distinctive.Home.pertemuan_2_laporan.HitungActivity
import com.example.tiara_distinctive.Home.pertemuan_4_laporan.SeventhActivity
import com.example.tiara_distinctive.Home.pertemuan_4_laporan.Custom2Activity
import com.example.tiara_distinctive.Home.pertemuan_6_laporan.WebViewActivity
import com.google.android.material.snackbar.Snackbar

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref =
            getSharedPreferences("session_user", MODE_PRIVATE)

        val username =
            intent.getStringExtra("USERNAME")
                ?: sharedPref.getString("username", "User")

        binding.textUsername.text =
            "Halo, $username 👋"

        // TOOLBAR
        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            title = "Welcome"
            subtitle = "Halaman Utama"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // BUTTON MENU
        binding.btnRumus.setOnClickListener {
            val intent =
                Intent(this, HitungActivity::class.java)

            intent.putExtra(
                "judul",
                "Menghitung Luas Segitiga dan Volume Kubus"
            )

            intent.putExtra(
                "deskripsi",
                "Halaman Hitung Rumus Bangun Ruang"
            )

            startActivity(intent)
        }

        binding.btnCustom1.setOnClickListener {
            val intent =
                Intent(this, SeventhActivity::class.java)

            intent.putExtra("judul", "Custom 1")
            intent.putExtra(
                "deskripsi",
                "Halaman Custom 1 berisi gambar dan text"
            )

            startActivity(intent)
        }

        binding.btnCustom2.setOnClickListener {
            val intent =
                Intent(this, Custom2Activity::class.java)

            intent.putExtra("judul", "Custom 2")
            intent.putExtra(
                "deskripsi",
                "Halaman Custom 2 berisi gambar dan text"
            )

            startActivity(intent)
        }

        binding.btnBinaDesa.setOnClickListener {
            startActivity(
                Intent(this, WebViewActivity::class.java)
            )
        }

        binding.btnLogout.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->

                    sharedPref.edit().clear().apply()

                    startActivity(
                        Intent(
                            this,
                            LoginActivity::class.java
                        )
                    )

                    finish()
                }

                .setNegativeButton("Tidak") { _, _ ->

                    Snackbar
                        .make(
                            binding.root,
                            "Logout dibatalkan",
                            Snackbar.LENGTH_SHORT
                        )
                        .show()
                }

                .show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        startActivity(
            Intent(this, LoginActivity::class.java)
        )

        finish()
        return true
    }

    // ===== PERTEMUAN 5: OPTION MENU =====
    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                android.widget.Toast.makeText(this, "Mencari fasilitas...", android.widget.Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                // Tampilkan snackbar atau dialog info
                Snackbar.make(binding.root, "Gunakan Bottom Navigation di halaman utama untuk Settings", Snackbar.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}