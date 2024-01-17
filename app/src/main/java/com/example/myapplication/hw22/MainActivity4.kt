package com.example.myapplication.hw22

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity4:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val tabLayout: TabLayout = findViewById(R.id.tl_main)


        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        val adapter = CategoryAdater(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Основные"
                1 -> tab.text = "Статистика"
                2 -> tab.text = "Еще один таб"
                else -> throw IllegalArgumentException("Invalid position: $position")
            }
        }.attach()
    }
}