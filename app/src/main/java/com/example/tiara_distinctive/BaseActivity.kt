package com.example.tiara_distinctive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tiara_distinctive.About.AboutFragment
import com.example.tiara_distinctive.Home.HomeFragment
import com.example.tiara_distinctive.Home.pertemuan_3_laporan.LoginActivity
import com.example.tiara_distinctive.Profile.ProfileFragment
import com.example.tiara_distinctive.Settings.SettingsFragment
import com.example.tiara_distinctive.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // VIEW BINDING
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

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