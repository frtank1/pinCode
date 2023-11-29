package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var listNews: Map<String, News>
    lateinit var listText: Map<String, TextView>

    lateinit var textBack: TextView
    lateinit var textForward: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listNews = intList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listText = initView()
        listNews.forEach { s, news ->
            listText[s]?.text  = news.title
        }

        listText.forEach { s, textView ->
            textView.setOnClickListener {
                openFrgment(s,listNews[s]?:News("Пустой","Пустой","Пустой"))
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    fun intList(): Map<String, News> {
        val mapNews = mutableMapOf<String, News>()

        val news1 = News("Заголовок 1", "Автор 1", "Текст новости 1")
        val news2 = News("Заголовок 2", "Автор 2", "Текст новости 2")
        val news3 = News("Заголовок 3", "Автор 3", "Текст новости 3")
        val news4 = News("Заголовок 3", "Автор 3", "Текст новости 3")
        val news5 = News("Заголовок 3", "Автор 3", "Текст новости 3")
        val news6 = News("Заголовок 3", "Автор 3", "Текст новости 3")

        mapNews["news1"] = news1
        mapNews["news2"] = news2
        mapNews["news3"] = news3
        mapNews["news3"] = news4
        mapNews["news5"] = news5
        mapNews["news6"] = news6

        return mapNews
    }

    fun initView():Map<String, TextView> {
        val mapView = mutableMapOf<String, TextView>()

        mapView["news1"] = requireActivity().findViewById(R.id.txt_news_one)
        mapView["news2"] = requireActivity().findViewById(R.id.txt_news_two)
        mapView["news3"] = requireActivity().findViewById(R.id.txt_news_three)
        mapView["news3"] = requireActivity().findViewById(R.id.txt_news_four)
        mapView["news5"] = requireActivity().findViewById(R.id.txt_news_five)
        mapView["news6"] = requireActivity().findViewById(R.id.txt_news_six)

        textBack= requireActivity().findViewById(R.id.txt_back)
        textForward= requireActivity().findViewById(R.id.txt_forward)
       return  mapView
    }

    fun openFrgment(s:String,news:News){
        parentFragmentManager
            .beginTransaction()
            .add(
                R.id.news_fragment,
                NewsFragment.newInstance(news),
                s)
            .addToBackStack(null)
            .commit()
    }



}