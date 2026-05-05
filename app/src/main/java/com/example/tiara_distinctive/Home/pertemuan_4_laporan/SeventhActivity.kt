package com.example.tiara_distinctive.Home.pertemuan_4_laporan

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.tiara_distinctive.R
import com.example.tiara_distinctive.Home.pertemuan_3_laporan.WelcomeActivity
import com.example.tiara_distinctive.Home.pertemuan_7.DuaFragment
import com.example.tiara_distinctive.Home.pertemuan_7.SatuFragment
import com.example.tiara_distinctive.Home.pertemuan_7.TigaFragment
import com.example.tiara_distinctive.databinding.ActivitySeventhBinding
import kotlin.math.abs

class SeventhActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySeventhBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        replaceFragment(SatuFragment())

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Seven Activity"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }


        binding.appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->

            if (verticalOffset == 0) {
                binding.appBar.elevation = 0f
            } else {
                binding.appBar.elevation = 80f
            }

            if (abs(verticalOffset) == appBarLayout.totalScrollRange) {
                supportActionBar?.subtitle = null
            } else {
                supportActionBar?.subtitle = "Ini adalah subtitle"
            }
        }

        binding.btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }
        binding.btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }

    // ✅ BACK TOOLBAR (←)
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}