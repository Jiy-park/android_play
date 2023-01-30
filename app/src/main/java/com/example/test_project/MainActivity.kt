package com.example.test_project

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.Toast
import androidx.annotation.Dimension
import androidx.annotation.Dimension.DP
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.test_project.databinding.ActivityMainBinding
import com.sothree.slidinguppanel.PanelState
import com.sothree.slidinguppanel.SlidingUpPanelLayout
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

        val slidePanel = binding.mainFrame                      // SlidingUpPanel

        binding.tvText1.setOnClickListener {
            if(binding.mainFrame.panelState == PanelState.COLLAPSED){
                binding.mainFrame.panelState = PanelState.ANCHORED
            }
        }

        // 터치로 슬라이드 가능 여부 설정 (panelState 변경으로 여닫는 건 가능)
        binding.btnTouch.setOnClickListener {
            val touchEnabled = slidePanel.isTouchEnabled
            if (touchEnabled) {
                binding.btnTouch.text = "잠금해제"
                slidePanel.isTouchEnabled = false
            } else {
                binding.btnTouch.text = "터치잠금"
                slidePanel.isTouchEnabled = true
            }
        }

        // 패널 활성화 여부 설정 (터치, 함수 모두 불가능)
        binding.btnEnable.setOnClickListener {
            val enabled = slidePanel.isEnabled
            if (enabled) {
                binding.btnEnable.text = "활성화"
                slidePanel.isEnabled = false
            } else {
                binding.btnEnable.text = "비활성화"
                slidePanel.isEnabled = true
            }
        }

    }

}
