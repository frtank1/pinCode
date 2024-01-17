package com.example.myapplication.hw22


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CategoryAdater(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MainFragment()
            1 -> StatisticFragment()
            2 -> AnotherFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}