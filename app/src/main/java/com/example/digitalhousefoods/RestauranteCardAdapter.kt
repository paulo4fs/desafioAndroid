package com.example.digitalhousefoods

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.model.Prato

class RestauranteCardAdapter(
    private val prato: ArrayList<Prato>,
    private val listener: (Prato) -> Unit
) :
    RecyclerView.Adapter<RestauranteCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteCardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_prato, parent, false)
        return RestauranteCardViewHolder(view)
    }

    override fun getItemCount() = prato.size

    override fun onBindViewHolder(holder: RestauranteCardViewHolder, position: Int) {
        val item = prato[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }
}