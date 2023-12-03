package com.example.myapplication.hw12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapterRecyclerView = AdapterCountryMoney()

        val managerRecyclerView = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)

        val countryMoneyList = listOf<Money>(
            Money(getString(R.string.tenge),R.drawable.img),
            Money(getString(R.string.dolars),R.drawable.img_1),
            Money(getString(R.string.lyra),R.drawable.img_2),
            Money(getString(R.string.euros),R.drawable.img_3)
        )

        adapterRecyclerView.setItems(countryMoneyList)

        recyclerView.apply {
            adapter = adapterRecyclerView
            layoutManager = managerRecyclerView
        }
    }
}