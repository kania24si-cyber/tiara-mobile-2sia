package com.example.tiara_distinctive.Home.pertemuan_10_laporan

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tiara_distinctive.R
import com.example.tiara_distinctive.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTenthBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "DesaSface"
            subtitle = "Bina Desa"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        val tabsAdapter = TenthTabsAdapter(this)

        binding.viewPager.adapter = tabsAdapter
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Layanan"
                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_home
                    )
                }

                1 -> {
                    tab.text = "Informasi"
                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_article
                    )
                }

                2 -> {
                    tab.text = "Fasilitas"
                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_profile
                    )
                }
            }
        }.attach()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}
