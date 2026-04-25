package com.example.tiara_distinctive.pertemuan_6_laporan

import android.os.Bundle
import android.os.Message
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebSettings
import android.webkit.WebView
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

        // ✅ PAKAI TOOLBAR SAJA (Bukan AppBarLayout)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            title = "Web Bina Desa"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // 🔧 WebView Settings
        binding.webView.settings.apply {
            javaScriptEnabled = true
            mixedContentMode =
                WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            cacheMode =
                WebSettings.LOAD_DEFAULT
        }

        binding.webView.clearCache(true)

        // 🌐 WebView Client
        binding.webView.webViewClient =
            object : WebViewClient() {

                override fun onPageStarted(
                    view: WebView?,
                    url: String?,
                    favicon: android.graphics.Bitmap?
                ) {
                    super.onPageStarted(
                        view,
                        url,
                        favicon
                    )

                    Toast.makeText(
                        this@WebViewActivity,
                        "Loading: $url",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onPageFinished(
                    view: WebView?,
                    url: String?
                ) {
                    super.onPageFinished(view, url)

                    Toast.makeText(
                        this@WebViewActivity,
                        "Finished: $url",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?
                ) {
                    super.onReceivedError(
                        view,
                        request,
                        error
                    )

                    Toast.makeText(
                        this@WebViewActivity,
                        "Error: ${error?.description}",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onReceivedHttpError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    errorResponse: WebResourceResponse?
                ) {
                    super.onReceivedHttpError(
                        view,
                        request,
                        errorResponse
                    )

                    Toast.makeText(
                        this@WebViewActivity,
                        "HTTP ${errorResponse?.statusCode}",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onFormResubmission(
                    view: WebView?,
                    dontResend: Message?,
                    resend: Message?
                ) {
                    resend?.sendToTarget()
                }
            }

        // 🌐 Load Website
        binding.webView.loadUrl(
            "https://tiara-fasilitasumum.alwaysdata.net/"
        )

        // ⬅️ Tombol Back HP
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

    // ⬅️ Tombol Panah Toolbar
    override fun onSupportNavigateUp(): Boolean {

        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            finish()
        }

        return true
    }
}