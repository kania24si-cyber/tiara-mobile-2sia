package com.example.tiara_distinctive.pertemuan_3_laporan

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiara_distinctive.databinding.ActivityLoginBinding
import com.example.tiara_distinctive.pertemuan_2_laporan.HitungActivity
import com.example.tiara_distinctive.pertemuan_4_laporan.Custom1Activity
import com.example.tiara_distinctive.pertemuan_4_laporan.Custom2Activity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val username = binding.inputUsername.text.toString()
            val password = binding.inputPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Harap isi semua field!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            }
        }

        }
    }