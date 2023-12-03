package com.example.myapplication.hw12

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.google.android.material.textfield.TextInputLayout

class AdapterCountryMoney(
):RecyclerView.Adapter<AdapterCountryMoney.RecylerItemViewHolder>() {

    private val data = mutableListOf<Money>()


    inner class RecylerItemViewHolder(inflater: LayoutInflater, parent:ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_recycle,parent,false)){
        private val countryMoney = itemView.findViewById<TextInputLayout>(R.id.outlinedTextField)
        private val imgCountry = itemView.findViewById<ImageView>(R.id.img_country)
        private val txtCountry = itemView.findViewById<TextView>(R.id.txt_country)

        fun bind(item:Money){
            countryMoney.hint = item.name
            txtCountry.text = item.name
            imgCountry.setImageResource(item.imageRes)
        }

    }

    fun setItems(list:List<Money>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecylerItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecylerItemViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecylerItemViewHolder, position: Int) {
        holder.bind(data[position])
    }
}