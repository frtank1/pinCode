package com.example.myapplication.hw19.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMain3Binding
import com.example.myapplication.hw19.model.Movie
import com.example.myapplication.hw19.model.getDefultCityArray


class MainFragmenMovie : Fragment() {
    private var _binding: FragmentMain3Binding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MovieAdapter
    private val movieData = getDefultCityArray()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMain3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MovieAdapter(object : OnItemViewClickListener {
            override fun onItemViewClick(movie: Movie) {
                activity?.supportFragmentManager?.apply {
                    beginTransaction()
                        .add(R.id.fragmetn_container, MaxPlayerFragment.newInstance(movie))
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
            }
        })

        binding.nowPlaying.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        binding.nowPlaying.adapter = adapter

        adapter.data.addAll( movieData)
        adapter.notifyDataSetChanged()

    }

    interface OnItemViewClickListener {
        fun onItemViewClick(movie: Movie)
    }

}