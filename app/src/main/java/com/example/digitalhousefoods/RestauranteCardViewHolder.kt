package com.example.digitalhousefoods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.model.Prato
import com.squareup.picasso.Picasso

class RestauranteCardViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val imagem = view.findViewById<ImageView>(R.id.ivImagemCardPratoRestaurante)
    private val nome = view.findViewById<TextView>(R.id.tvNomePratoCardRestaurante)

    fun bind(pratos: Prato) {
        nome.text = pratos.nome
        Picasso.get().load(pratos.imagem).into(imagem)
    }
}