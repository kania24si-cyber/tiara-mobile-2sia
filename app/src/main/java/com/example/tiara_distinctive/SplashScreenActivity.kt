package com.example.tiara_distinctive

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.tiara_distinctive.pertemuan_3_laporan.LoginActivity
import com.example.tiara_distinctive.pertemuan_3_laporan.WelcomeActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {


            delay(2000)

            val sharedPref =
                getSharedPreferences("session_user", MODE_PRIVATE)

            val isLogin =
                sharedPref.getBoolean("isLogin", false)


            if (isLogin) {

                val username =
                    sharedPref.getString("username", "")

                val intent = Intent(
                    this@SplashScreenActivity,
                    WelcomeActivity::class.java
                )

                intent.putExtra("USERNAME", username)

                startActivity(intent)

            } else {

                startActivity(
                    Intent(
                        this@SplashScreenActivity,
                        LoginActivity::class.java
                    )
                )
            }

            finish()
        }
    }
}