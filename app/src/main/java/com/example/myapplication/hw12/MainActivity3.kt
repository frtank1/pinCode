package com.example.myapplication.hw12

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
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
import com.google.android.material.snackbar.Snackbar


class MainActivity3 : AppCompatActivity(),OnButtonClickListener,OnButtonDialogClickListener {
    lateinit var adapterRecyclerView : AdapterCountryMoney
    val toolbar: Toolbar by lazy { findViewById(R.id.toolbar_main) }
    private var index = -1
    private var currentItem = -1
    val dialog =  MyDialogFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

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

    override fun onLongClickListener(index: Int) {
        with(toolbar){
            deleteToolbar()
            currentItem = index
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        when(index){
            -1 ->{
                menu?.findItem(R.id.sort_by_name)?.isCheckable = false
            }
            0 -> menu?.findItem(R.id.sort_by_name)?.isCheckable = true
             1 ->menu?.findItem(R.id.sort_by_name)?.isCheckable = true
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sort_by_name-> {
                index = 0
                adapterRecyclerView.sortByALphabe()
                true
            }
            R.id.reset_sort -> {
                index = -1
                adapterRecyclerView.resetItems()
                true
            }
            R.id.sort_by_amount->{
                index = 1
                adapterRecyclerView.sortByALphabe()
                true
            }
            R.id.delete_item ->{
                initialAlertDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun initialAlertDialog(){

        dialog.show(supportFragmentManager, "MyDialogFragmentTag")
    }

    private fun returnToolbar(){
        with(toolbar){
            getMenu().clear()
            inflateMenu(R.menu.menu)
            setTitle("Main Activity")
            background = getDrawable(R.drawable.shape_toolbar)
        }
    }

    private fun deleteToolbar(){
        with(toolbar){
            getMenu().clear()
            inflateMenu(R.menu.menu_delete)
            setTitle("Item selected")
            setBackgroundColor(getColor(R.color.grey))
        }
    }

    override fun onButtonDismis() {
        returnToolbar()
    }

    override fun onButtonDelete() {
        if (currentItem>-1){
            adapterRecyclerView.deleteItem(currentItem)
            adapterRecyclerView.notifyItemRemoved(currentItem)
            returnItemRecycler()
            returnToolbar()
        }
    }

     fun returnItemRecycler() {
        val mySnackbar = Snackbar.make(findViewById(android.R.id.content), "Удалил, Вернуть?", Snackbar.LENGTH_SHORT)
        mySnackbar.setAction("отмена") { adapterRecyclerView.returnItem()}
        mySnackbar.show()
         currentItem =-1
    }

}




interface OnButtonClickListener{
    fun onButtonClick()
    fun onLongClickListener(index:Int)
}


interface OnButtonDialogClickListener{
    fun onButtonDismis()
    fun onButtonDelete()

}

