package com.example.newsprogramboys

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private lateinit var botaoBrasil: ImageButton
    private lateinit var botaoEua: ImageButton
    private lateinit var botaoLondres: ImageButton
    private lateinit var botaoChina: ImageButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Denomina o botão que a variável se refere
        botaoBrasil = findViewById(R.id.botaoBrasil)

        //Intent para o botão levar a página de noticias.
        botaoBrasil.setOnClickListener {
            //Denomina para qual activity o botão vai levar ao ser clicado
            val intent = Intent(this, NoticiasBrasil::class.java)
            startActivity(intent)
        }

        botaoEua = findViewById(R.id.botaoEUA)

        botaoEua.setOnClickListener {

            val intent = Intent(this, NoticiasEUA::class.java)
            startActivity(intent)
        }

        botaoLondres = findViewById(R.id.botaoLondres)

        botaoLondres.setOnClickListener {

            val intent = Intent(this, NoticiasInglaterra::class.java)
            startActivity(intent)
        }

        botaoChina = findViewById(R.id.botaoChina)

        botaoChina.setOnClickListener {

            val intent = Intent(this, NoticiasChina::class.java)
            startActivity(intent)
        }

    }
}