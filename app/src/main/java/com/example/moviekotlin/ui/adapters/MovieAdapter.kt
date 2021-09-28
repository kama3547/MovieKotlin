package com.example.moviekotlin.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviekotlin.databinding.ItemMovieBinding
import com.example.moviekotlin.model.Movie

class MovieAdapter(private var list: List<Movie>, private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: Movie) {
            binding.itemDesk.text = model.name
            binding.itemImage.load(model.image.original) {
                crossfade(true)
                crossfade(1000)
            }
            itemView.setOnClickListener {
                listener(model.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind(list[position])

    override fun getItemCount(): Int = list.size
}