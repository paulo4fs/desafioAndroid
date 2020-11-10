package com.example.digitalhousefoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class PratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prato)
        closeButton()

        val imagem = intent.getIntExtra("imagem", R.drawable.iv_raster)
        val nome = intent.getStringExtra("nome")
        val descricao = intent.getStringExtra("descricao")

        val imagemPrato = findViewById<ImageView>(R.id.ivImagemPrato)
        val nomePrato = findViewById<TextView>(R.id.tvTituloPrato)
        val descricaoPrato = findViewById<TextView>(R.id.tvDescricaoprato)

        nomePrato.text = nome
        descricaoPrato.text = descricao
        Picasso.get().load(imagem).into(imagemPrato)
    }

    private fun closeButton() {
        var backButton = findViewById<ImageButton>(R.id.ibVoltarPrato)
        backButton.setOnClickListener {
            finish()
        }
    }
}