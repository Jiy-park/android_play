package com.example.test_project

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.test_project.databinding.ActivityMainBinding
import render.animations.Attention
import render.animations.Bounce
import render.animations.Render
import java.time.Duration
import java.time.LocalDateTime


class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val render = Render(this@MainActivity)
        var mItem_list = mutableListOf<String>()
        mItem_list.run {
            add("박지용")
            add("이현진")
            add("으아")
        }

        val adapter = ViewPagerAdapter(this@MainActivity)
        adapter.item_list = mItem_list

        binding.viewPager.adapter = adapter
        binding.viewPager.offscreenPageLimit = 3
        binding.run {
            btnAdd.setOnClickListener {
                if(edName.text.toString() == ""){
                    render.setAnimation(Attention().Bounce(edName))
                    render.setDuration(500L)
                    render.start()
                }
                else{
                    adapter.add_item(edName.text.toString())
                    edName.text.clear()
                    Toast.makeText(this@MainActivity, "item_list size : ${mItem_list.size}",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

}