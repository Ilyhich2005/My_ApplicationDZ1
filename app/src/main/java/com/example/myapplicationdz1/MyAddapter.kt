package com.example.myapplicationdz1

import android.util.Log
import com.example.myapplicationdz1.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationdz1.databinding.MyItemLayoutBinding
class MyAddapter: RecyclerView.Adapter<MyAddapter.MyViewHolder>() {
    val item_list = ArrayList<Item>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_item_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.bind(item_list[position])
    }

    override fun getItemCount(): Int {
        return item_list.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = MyItemLayoutBinding.bind(view)
        fun bind(item: Item){
            binding.numbText.text = item.number.toString()
            binding.numbText.setBackgroundColor(
                ContextCompat.getColor(binding.root.context, item.color)
            )
        }
    }
    fun add_item(item: Item){
        item_list.add(item)
        notifyItemInserted(item_list.size-1)
    }

    fun setItems(items: ArrayList<Item>) {
        item_list.clear()
        item_list.addAll(items)
        notifyDataSetChanged()
    }
}