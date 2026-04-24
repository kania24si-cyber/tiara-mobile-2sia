package com.example.tiara_distinctive.pertemuan_6_laporan

import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.tiara_distinctive.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Web Bina Desa"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        binding.webView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(
                view: android.webkit.WebView?,
                url: String?,
                favicon: android.graphics.Bitmap?
            ) {
                Toast.makeText(
                    this@WebViewActivity,
                    "Loading...",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onPageFinished(
                view: android.webkit.WebView?,
                url: String?
            ) {
                Toast.makeText(
                    this@WebViewActivity,
                    "Selesai",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.webView.settings.javaScriptEnabled = true

        // ✅ BAGIAN YANG DIGANTI
        binding.webView.loadUrl(
            "https://tiara-fasilitasumum.alwaysdata.net/"
        )

        binding.webView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->

            if (scrollY > oldScrollY) {
                binding.appBar.setExpanded(false, true)
            } else if (scrollY < oldScrollY) {
                binding.appBar.setExpanded(true, true)
            }
        }

        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                    if (binding.webView.canGoBack()) {
                        binding.webView.goBack()
                    } else {
                        finish()
                    }
                }
            }
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}