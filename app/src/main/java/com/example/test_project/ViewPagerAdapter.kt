package com.example.test_project

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.test_project.databinding.ItemBinding
import render.animations.Bounce
import render.animations.Render


class Holder(val binding: ItemBinding):RecyclerView.ViewHolder(binding.root){
    fun setting(name:String, position:Int){
        Log.d("LOG_CHECK", "Holder :: setting() called")
        Log.d("LOG_CHECK", "Holder :: setting() called : name = $name position = $position")
        binding.btn1.run{
            text = name
            setOnClickListener {
                val render = Render(context)
                render.setAnimation(Bounce().InUp(this))
                render.start()
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show()
            }
        }
        Log.d("LOG_CHECK", "Holder :: setting() end")
    }

}

class ViewPagerAdapter(context: Context):RecyclerView.Adapter<Holder>() {
    var item_list = mutableListOf<String>()
    val mContext = context

    init {
        Log.d("LOG_CHECK", "ViewPagerAdapter :: () called")
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        Log.d("LOG_CHECK", "ViewPagerAdapter :: onCreateViewHolder() called")
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.d("LOG_CHECK", "ViewPagerAdapter :: onBindViewHolder() called")
        val name:String = item_list[position]
        holder.setting(name, position)
    }

    override fun getItemCount() = item_list.size
    fun add_item(name: String){
        item_list.add(name)
        notifyDataSetChanged()
        Log.d("LOG_CHECK", "ViewPagerAdapter :: add_item() called size : ${item_list.size}")
    }
}

