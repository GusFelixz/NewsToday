package com.example.newsprogramboys

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class NoticiasEUA : AppCompatActivity() {
    private lateinit var botaoVoltaEUA: ImageButton
        override fun onBackPressed() {
            val webView = findViewById<WebView>(R.id.webNoticiasEUA)
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                super.onBackPressed()
            }
        }

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_noticias_eua)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
        }

        // Configura o WebView
        val webView = findViewById<WebView>(R.id.webNoticiasEUA)
        webView.settings.javaScriptEnabled = true

        // Habilita o JavaScript (se o site precisar)
        webView.settings.javaScriptEnabled = true

        // Faz com que o WebView abra os links dentro do app, não no navegador
        webView.webViewClient = WebViewClient()

        // Carrega o site de notícias
        webView.loadUrl("https://www.nytimes.com/")  // URL de um site de notícias brasileiro

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url!!)
                return true
            }
        }
        botaoVoltaEUA = findViewById(R.id.botaoVoltaEUA)


        botaoVoltaEUA.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}


