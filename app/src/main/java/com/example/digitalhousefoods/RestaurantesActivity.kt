package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.model.Prato
import com.example.digitalhousefoods.model.Restaurante

class RestaurantesActivity : AppCompatActivity() {
//    Dados dos restaurantes
    private val _restaurantes = listOf(
        Restaurante(
            "Tony Roma's",
            "Av. Lavandisca, 717 - Indianópolis, São Paulo",
            "Fecha às 22:00",
            R.drawable.iv_tonyroma,
            arrayListOf(
                Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                )
            )
        ), Restaurante(
            "Aoyama - Moema",
            "Alameda dos Arapanés, 532 - Moema",
            "Fecha às 00:00",
            R.drawable.iv_aoyama,
            arrayListOf(
                Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                )
            )
        ), Restaurante(
            "Outback - Moema",
            "Av. Moaci, 187, 187 - Moema, São Paulo",
            "Fecha às 00:00",
            R.drawable.iv_outback,
            arrayListOf(
                Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                )
            )
        ), Restaurante(
            "Sí Señor!",
            "Alameda Jauaperi, 626 - Moema",
            "Fecha às 01:00",
            R.drawable.iv_senor,
            arrayListOf(
                Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                ), Prato(
                    "Salada com molho Gengibre",
                    "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
                    R.drawable.iv_aoyama
                )
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurantes)

        val viewManager = GridLayoutManager(this, 1)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRestaurante)

        val restauranteAdapter = RestaurantesAdapter(_restaurantes) {
            val intent = Intent(
                this,
                RestauranteCardActivity::class.java
            )
//            passagem de dados para activity restauranteCard
            intent.putExtra("nome", it.nome)
            intent.putExtra("imagem", it.imagem)
            intent.putExtra("prato", it.prato)

            startActivity(intent)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = restauranteAdapter
        }
    }
}