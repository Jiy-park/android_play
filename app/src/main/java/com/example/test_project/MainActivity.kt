package com.example.test_project

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
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

        binding.run {
            val render = Render(this@MainActivity)
            btn.setOnClickListener {
                render.setAnimation(Bounce().InDown(tv))
                tv.visibility = View.VISIBLE
                render.start()
            }
            btn2.setOnClickListener {
                when(tv.visibility){
                    View.VISIBLE -> {
                        render.setAnimation(Bounce().InUp(tv))
                        tv.visibility = View.GONE
                        render.start()
                    }
                    View.GONE -> {
                        render.setAnimation(Attention().Wobble(btn2))
                        render.setDuration(500L)
                        render.start()
                    }
                }
            }
        }

    }

}