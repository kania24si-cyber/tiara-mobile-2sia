package com.example.tiara_distinctive.pertemuan_3_laporan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tiara_distinctive.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME")
        binding.textUsername.text = "Halo, $username 👋"
    }
}