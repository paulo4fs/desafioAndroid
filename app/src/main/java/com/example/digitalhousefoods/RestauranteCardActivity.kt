package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.model.Prato
import com.squareup.picasso.Picasso

class RestauranteCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_card)

        closeButton()

        val imagem = intent.getIntExtra("imagem", R.drawable.iv_raster)
        val nome = intent.getStringExtra("nome")
        val prato = intent.getSerializableExtra("prato") as ArrayList<Prato>

        val imagemRestaurante = findViewById<ImageView>(R.id.ivImagemRestaurante)
        val tituloRestaurante = findViewById<TextView>(R.id.tvTituloRestaurante)

        Picasso.get().load(imagem).into(imagemRestaurante)
        tituloRestaurante.text = nome

        val viewManager = GridLayoutManager(this, 2)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPrato)

//        passagem de dados para a activity Prato
        val restauranteCardAdapter = RestauranteCardAdapter(prato) {
            val intent = Intent(
                this,
                PratoActivity::class.java
            )
            intent.putExtra("imagem", it.imagem)
            intent.putExtra("nome", it.nome)
            intent.putExtra("descricao", it.descricao)
            startActivity(intent)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = restauranteCardAdapter
        }
    }

    private fun closeButton() {
        var backButton = findViewById<ImageButton>(R.id.ibVoltarRestaurante)
        backButton.setOnClickListener {
            finish()
        }
    }
}