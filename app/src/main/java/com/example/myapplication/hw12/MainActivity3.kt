package com.example.myapplication.hw12

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainActivity3 : AppCompatActivity() {
    lateinit var btnAdd: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val countryMoneyList = mutableListOf<Money>(
            Money(getString(R.string.tenge), R.drawable.img),
            Money(getString(R.string.dolars), R.drawable.img_1),
            Money(getString(R.string.lyra), R.drawable.img_2),
            Money(getString(R.string.euros), R.drawable.img_3)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        btnAdd = findViewById(R.id.btn_add)

        val adapterRecyclerView = AdapterCountryMoney()

        val smoothScroller = object : LinearSmoothScroller(this) {
            override fun getVerticalSnapPreference(): Int = LinearSmoothScroller.SNAP_TO_START

        }
        val managerRecyclerView = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterRecyclerView.setItems(countryMoneyList)


        recyclerView.apply {
            adapter = adapterRecyclerView
            layoutManager = managerRecyclerView
            //itemAnimator = DefaultItemAnimator()
        }

        btnAdd.setOnClickListener {

            adapterRecyclerView.setItem(
                Money(
                    getString(R.string.dolars),
                    R.drawable.img_1
                )
            )
            smoothScroller.targetPosition = countryMoneyList.lastIndex+1
            managerRecyclerView?.startSmoothScroll(smoothScroller)
        }

    }

}