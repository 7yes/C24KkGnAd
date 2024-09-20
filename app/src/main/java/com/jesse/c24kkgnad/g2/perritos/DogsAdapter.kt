package com.jesse.c24kkgnad.g2.perritos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jesse.c24kkgnad.R
import com.jesse.c24kkgnad.databinding.ItemSmallDogsBinding
import com.jesse.c24kkgnad.load

class DogsAdapter(val images:List<String>):RecyclerView.Adapter<DogsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
               return DogsViewHolder(layoutInflater.inflate(R.layout.item_small_dogs, parent, false))
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        holder.bind(images[position])
    }
}

class DogsViewHolder(view: View):RecyclerView.ViewHolder(view) {
       private val binding= ItemSmallDogsBinding.bind ( view )

    fun bind(s: String) {
        binding.image.load(s)
    }
}