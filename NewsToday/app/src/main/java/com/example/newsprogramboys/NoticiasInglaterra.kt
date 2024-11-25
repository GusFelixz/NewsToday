package com.example.newsprogramboys

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class NoticiasInglaterra : AppCompatActivity() {
    private lateinit var botaoVoltaUK: ImageButton
        override fun onBackPressed() {
            val webView = findViewById<WebView>(R.id.webNoticiasLondres)
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                super.onBackPressed()
            }
        }

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_noticias_inglaterra)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
            // Configura o WebView
            val webView = findViewById<WebView>(R.id.webNoticiasLondres)

            // Habilita o JavaScript (se o site precisar)
            webView.settings.javaScriptEnabled = true

            // Faz com que o WebView abra os links dentro do app, não no navegador
            webView.webViewClient = WebViewClient()

            // Carrega o site de notícias
            webView.loadUrl("https://www.theguardian.com/uk-news#:~:text=Gostar%C3%ADamos%20de%20exibir%20a%20descri%C3%A7%C3%A3oaqui,%20mas%20o%20site%20que%20voc%C3%AA")  // URL de um site de notícias brasileiro

            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url!!)
                    return true
                }
            }
            botaoVoltaUK = findViewById(R.id.botaoVoltaUK)

            botaoVoltaUK.setOnClickListener {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }