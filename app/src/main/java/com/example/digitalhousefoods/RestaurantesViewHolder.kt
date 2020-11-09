package com.example.digitalhousefoods

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.model.Restaurante
import com.squareup.picasso.Picasso

class RestaurantesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val imagem = view.findViewById<ImageView>(R.id.ivImagemCardRestaurante)
    private val nome = view.findViewById<TextView>(R.id.tvNomeCardRestaurante)
    private val endereco = view.findViewById<TextView>(R.id.tvEnderecoCardRestaurante)
    private val aberto = view.findViewById<TextView>(R.id.tvAbertoCardRestaurante)

    fun bind(restaurantes: Restaurante) {
        nome.text = restaurantes.nome
        endereco.text = restaurantes.endereco
        aberto.text = restaurantes.aberto
        Picasso.get().load(restaurantes.imagem).into(imagem)
    }
}