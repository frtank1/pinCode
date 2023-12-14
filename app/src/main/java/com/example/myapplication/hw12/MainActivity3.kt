package com.example.myapplication.hw12

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.DOWN
import androidx.recyclerview.widget.ItemTouchHelper.END
import androidx.recyclerview.widget.ItemTouchHelper.START
import androidx.recyclerview.widget.ItemTouchHelper.UP
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R


class MainActivity3 : AppCompatActivity(),OnButtonClickListener {
    lateinit var adapterRecyclerView : AdapterCountryMoney
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        val countryMoneyList = mutableListOf<ImMainInterface>(
            Money(getString(R.string.tenge), R.drawable.img),
            Money(getString(R.string.dolars), R.drawable.img_1),
            Money(getString(R.string.lyra), R.drawable.img_2),
            Money(getString(R.string.euros), R.drawable.img_3),
            ButtonItem()
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapterRecyclerView = AdapterCountryMoney(this)


        val managerRecyclerView = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterRecyclerView.setItems(countryMoneyList)


        recyclerView.apply {
            adapter = adapterRecyclerView
            layoutManager = managerRecyclerView
            //itemAnimator = DefaultItemAnimator()
        }

        itemToucheHelper.attachToRecyclerView(recyclerView)


        /*btnAdd.setOnClickListener {

            adapterRecyclerView.setItem(
                Money(
                    getString(R.string.dolars),
                    R.drawable.img_1
                )
            )
            smoothScroller.targetPosition = countryMoneyList.lastIndex + 1
            managerRecyclerView?.startSmoothScroll(smoothScroller)
        }*/

    }
    val itemToucheHelper by lazy {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(UP or DOWN , START or END) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val adapter = recyclerView.adapter as AdapterCountryMoney
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition
                adapter.moveItem(from, to)
                adapter.notifyItemMoved(from, to)

                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (adapterRecyclerView.lastIndex()!=position)
                adapterRecyclerView.deleteItem(position)
                adapterRecyclerView.notifyItemRemoved(position)
            }
        })
    }



    override fun onButtonClick() {
        val smoothScroller = object : LinearSmoothScroller(this) {
            override fun getVerticalSnapPreference(): Int = LinearSmoothScroller.SNAP_TO_START
        }

        adapterRecyclerView.setItem(
            Money(
                getString(R.string.dolars),
                R.drawable.img_1
            )
        )

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sort_by_name, R.id.sort_by_amount -> {
                adapterRecyclerView.sortByALphabe()
                true
            }
            R.id.reset_sort -> {
                adapterRecyclerView.resetItems()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}

interface OnButtonClickListener{
    fun onButtonClick()
}
