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


class NoticiasBrasil : AppCompatActivity() {
        private lateinit var botaoVoltaBrasili: ImageButton
        override fun onBackPressed() {
            val webView = findViewById<WebView>(R.id.webNoticias)
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
        setContentView(R.layout.activity_noticias_brasil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
                // Configura o WebView
                val webView = findViewById<WebView>(R.id.webNoticias)

                // Habilita o JavaScript (se o site precisar)
                webView.settings.javaScriptEnabled = true

                // Faz com que o WebView abra os links dentro do app, não no navegador
                webView.webViewClient = WebViewClient()

                // Carrega o site de notícias
                webView.loadUrl("https://www.g1.com.br")  // URL de um site de notícias brasileiro

                webView.webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                        view?.loadUrl(url!!)
                        return true
                    }
                }

            botaoVoltaBrasili = findViewById(R.id.botaoVoltaBrasili)


            botaoVoltaBrasili.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            }

    }

}

