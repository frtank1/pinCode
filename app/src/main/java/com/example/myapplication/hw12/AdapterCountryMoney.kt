package com.example.myapplication.hw12

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.google.android.material.textfield.TextInputLayout


class AdapterCountryMoney(
    private val onButtonClickListener: OnButtonClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val VIEW_TYPE_CURRENCY = 1
        private const val VIEW_TYPE_ADD_BUTTONS = 2
    }
    private var data = mutableListOf<ImMainInterface>()
    private var originalData = mutableListOf<ImMainInterface>()

    fun setItems(list: List<ImMainInterface>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun lastIndex():Int{
        return data.lastIndex
    }
    fun setItem(money:Money){
        data.add(data.size-1,money)
        notifyItemChanged(data.size-1)
    }

    fun resetItems() {
        data.clear()
        data.addAll(originalData)
        notifyDataSetChanged()
    }

    fun setItemToPosition(money:Money, position: Int){
        data.add(position,money)
        notifyItemChanged(position)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        when(viewType){
            VIEW_TYPE_CURRENCY -> {
                return RecylerItemViewHolder(inflater, parent)
            }
            VIEW_TYPE_ADD_BUTTONS ->{
                return  RecylerButtonViewHolder(inflater,parent)
            }
        }
        return RecylerItemViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = when(data[position]){
            is Money -> VIEW_TYPE_CURRENCY
            is ButtonItem -> VIEW_TYPE_ADD_BUTTONS
            else -> VIEW_TYPE_CURRENCY
        }

    fun sortByALphabe(){
        val last = data.removeLast()
        data = data.sortedBy {
            when(it){
                is Money ->it.name
                else -> ""
            }
        }.toMutableList()
        notifyDataSetChanged()

        data.add(last   )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is RecylerItemViewHolder ->{
                holder.bind(data[position])
            }
            is RecylerButtonViewHolder ->{
                holder.bind(onButtonClickListener)
            }
        }
    }

    fun moveItem(from: Int, to: Int) {
        val item = data.removeAt(from)
        data.add(to,item)
    }

    fun deleteItem(from: Int){
        if(data.lastIndex!=from)
        data.removeAt(from)
    }
}


class RecylerItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_recycle, parent, false)) {
    private val countryMoney = itemView.findViewById<TextInputLayout>(R.id.outlinedTextField)
    private val imgCountry = itemView.findViewById<ImageView>(R.id.img_country)
    private val txtCountry = itemView.findViewById<TextView>(R.id.txt_country)

    fun bind(item: ImMainInterface ) {
        item as Money
        countryMoney.hint = item.name
        txtCountry.text = item.name
        imgCountry.setImageResource(item.imageRes)
    }
}

class RecylerButtonViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_button, parent, false)) {
    private val addButons = itemView.findViewById<Button>(R.id.btn_add)
    fun bind(onButtonClickListener:OnButtonClickListener) {
        addButons.setOnClickListener {
            onButtonClickListener.onButtonClick()
        }
    }
}