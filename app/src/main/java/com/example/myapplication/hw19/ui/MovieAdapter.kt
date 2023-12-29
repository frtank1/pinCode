package com.example.myapplication.hw19.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemMovieBinding
import com.example.myapplication.hw19.model.Movie

class MovieAdapter(
    private var onItemViewClickListener: MainFragmenMovie.OnItemViewClickListener?,
):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var data:MutableList<Movie> = mutableListOf()
        set(newValue){
            if (field.isEmpty())
                field =newValue
            else
                field.addAll(newValue)
        }

    class MovieViewHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent,false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size


    fun setMovie(item:MutableList<Movie> ){
        data.addAll(item)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = data[position]
        with(holder.binding){
            player.setOnClickListener{
                onItemViewClickListener?.onItemViewClick(movie)
            }
        }
    }

}