package com.example.myapplication.hw7to10pincode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val NEWS_TAG = "NEWS"


class NewsFragment : Fragment() {

    lateinit private var news: News
    lateinit var textTitle: TextView
    lateinit var textAuthor: TextView
    lateinit var textNews: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            news = it.getSerializable(NEWS_TAG) as News
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textTitle = view.findViewById(R.id.txt_tile_body)
        textAuthor = view.findViewById(R.id.txt_author_body)
        textNews = view.findViewById(R.id.txt_news_body)

        textTitle.text = news.title
        textAuthor.text = news.author
        textNews.text = news.news
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(news: News) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(NEWS_TAG, news)
                }
            }
    }
}