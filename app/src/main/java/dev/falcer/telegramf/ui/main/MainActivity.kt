package dev.falcer.telegramf.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import dev.falcer.telegramf.R
import dev.falcer.telegramf.data.OnBoard
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val pagers = listOf(
        OnBoard(
            "Telegram X",
            "The world's fastest messaging app.\nIt is free and secure",
            0,
            73,
            false
        ),
        OnBoard(
            "Fast",
            "The world's fastest messaging app.\nIt is free and secure",
            73,
            168
        ),
        OnBoard(
            "Free",
            "The world's fastest messaging app.\nIt is free and secure",
            168,
            300
        )
    )

    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        setContentView(R.layout.activity_main)
        setupAdapter()
        setupViewPager()
        setupDotIndicator()
    }

    private fun setupAdapter() {
        adapter.setData(pagers)
    }

    private fun setupViewPager() {
        vp_main.adapter = adapter
        vp_main.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                animation_view.setMinFrame(pagers[position].startAnimateFrom!!)
                animation_view.setMaxFrame(pagers[position].endAnimateFrom!!)
                animation_view.playAnimation()
            }
        })
    }

    private fun setupDotIndicator() {
        dotIndicator_main.setViewPager2(vp_main)
    }
}
