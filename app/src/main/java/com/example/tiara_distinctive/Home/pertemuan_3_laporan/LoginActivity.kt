package com.example.tiara_distinctive.Home.pertemuan_3_laporan

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tiara_distinctive.R
import com.example.tiara_distinctive.databinding.ActivityLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        sharedPref = getSharedPreferences("session_user", MODE_PRIVATE)

        // BUTTON LOGIN
        binding.btnLogin.setOnClickListener {

            val username = binding.inputUsername.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()

            // reset error
            binding.inputUsername.error = null
            binding.inputPassword.error = null

            val savedUsername = sharedPref.getString("username", "")
            val savedPassword = sharedPref.getString("password", "")

            // VALIDASI USERNAME
            if (username.isEmpty()) {

                binding.inputUsername.error = "Username wajib diisi"

            }
            // VALIDASI PASSWORD
            else if (password.isEmpty()) {

                binding.inputPassword.error = "Password wajib diisi"

            }

            // RULE 1
            // username == password
            else if (username == password) {

                val editor = sharedPref.edit()

                editor.putBoolean("isLogin", true)
                editor.apply()

                val intent = Intent(
                    this,
                    WelcomeActivity::class.java
                )

                intent.putExtra("USERNAME", username)

                startActivity(intent)
                finish()
            }

            // RULE 2
            // login dari SharedPreferences
            else if (
                username == savedUsername &&
                password == savedPassword
            ) {

                val editor = sharedPref.edit()

                editor.putBoolean("isLogin", true)
                editor.apply()

                val intent = Intent(
                    this,
                    WelcomeActivity::class.java
                )

                intent.putExtra("USERNAME", username)

                startActivity(intent)
                finish()
            }

            // LOGIN GAGAL
            else {

                MaterialAlertDialogBuilder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Username atau Password salah")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }

        // BUTTON REGISTRASI
        binding.buttonRegist.setOnClickListener {

            val intent = Intent(
                this,
                RegistrasiActivity::class.java
            )

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "LoginActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "LoginActivity dihapus dari stack")
    }
}