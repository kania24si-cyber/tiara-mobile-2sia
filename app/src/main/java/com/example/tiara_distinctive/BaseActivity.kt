package com.example.tiara_distinctive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tiara_distinctive.About.AboutFragment
import com.example.tiara_distinctive.Agenda.AgendaFragment
import com.example.tiara_distinctive.Home.HomeFragment
import com.example.tiara_distinctive.Home.pertemuan_3_laporan.LoginActivity
import com.example.tiara_distinctive.Pengaduan.PengaduanFragment
import com.example.tiara_distinctive.Profile.ProfileFragment
import com.example.tiara_distinctive.Settings.SettingsFragment
import com.example.tiara_distinctive.databinding.ActivityBaseBinding
import android.Manifest
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tiara_distinctive.utils.PermissionHelper

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding
    private val notificationPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->

            if (isGranted) {
                Toast.makeText(this, "Notifikasi diizinkan", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Notifikasi ditolak", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // VIEW BINDING
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (PermissionHelper.isNotificationPermissionRequired()) {

            val permission = Manifest.permission.POST_NOTIFICATIONS

            if (!PermissionHelper.hasPermission(this, permission)) {

                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
        }

        // TOOLBAR
        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {

            title = "Welcome"
            subtitle = "Halaman Utama"

            // tombol back toolbar
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // BOTTOM NAVIGATION
        binding.bottomNavView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> {

                    supportActionBar?.title = "Welcome"
                    supportActionBar?.subtitle = "Halaman Utama"

                    replaceFragment(HomeFragment())

                    true
                }

                R.id.about -> {

                    supportActionBar?.title = "About"
                    supportActionBar?.subtitle = "Tentang Aplikasi"

                    replaceFragment(AboutFragment())

                    true
                }

                R.id.profile -> {

                    supportActionBar?.title = "Profile"
                    supportActionBar?.subtitle = "Data Pengguna"

                    replaceFragment(ProfileFragment())

                    true
                }
                R.id.listSettings -> {

                    supportActionBar?.title = "Settings"
                    supportActionBar?.subtitle = "Menu Pengaturan"

                    replaceFragment(SettingsFragment())

                    true
                }

                R.id.menu_pengaduan -> {
                    replaceFragment(PengaduanFragment())
                    true
                }
                R.id.menu_agenda -> {
                    replaceFragment(AgendaFragment())
                    true
                }

                else -> false
            }
        }

        // HOME DEFAULT
        binding.bottomNavView.selectedItemId = R.id.home
    }

    // KLIK PANAH TOOLBAR
    override fun onSupportNavigateUp(): Boolean {

        startActivity(
            Intent(this, LoginActivity::class.java)
        )

        finish()
        return true
    }

    // GANTI FRAGMENT
    private fun replaceFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}