package com.example.digitalhousefoods

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.model.Restaurante

class RestaurantesAdapter(
    private val restaurante: List<Restaurante>,
    private val listener: (Restaurante) -> Unit
) :
    RecyclerView.Adapter<RestaurantesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): RestaurantesViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_restaurante, parent, false)

        return RestaurantesViewHolder(view)
    }

    override fun getItemCount() = restaurante.size

    override fun onBindViewHolder(holder: RestaurantesViewHolder, position: Int) {
        val item = restaurante[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }
}