package com.example.myapplication.hw19

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMain5Binding
import com.example.myapplication.hw19.ui.MainFragmenMovie

private lateinit var binding: ActivityMain5Binding

class MainActivity5:AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(MainFragmenMovie())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->replaceFragment(MainFragmenMovie())
                R.id.favorites->replaceFragment(MainFragmenMovie())
                R.id.setings->replaceFragment(MainFragmenMovie())
            }
            true
        }
    }

    private fun replaceFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmetn_container,fragment)
            .commit()
    }
}