package com.example.myapplication.hw19.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMaxPlayerBinding
import com.example.myapplication.hw19.model.Movie

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"


class MaxPlayerFragment : Fragment() {
    private var _binding : FragmentMaxPlayerBinding? = null
    private val binding get() = _binding!!

    private var item: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            item = it.getParcelable(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMaxPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(item!=null) {
            val imageUrl = item!!.imageUrl
            binding.viewMovie.setImageDrawable(requireActivity().getDrawable(imageUrl))
            binding.closeIcon.setOnClickListener {
                activity?.supportFragmentManager?.apply {
                    popBackStack()
                }
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(movie: Movie) =
            MaxPlayerFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, movie)
                }
            }
    }
}