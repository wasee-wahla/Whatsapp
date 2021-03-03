package com.notin.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.notin.whatsapp.adapters.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var mainPagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        addTabs()
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = mainPagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }
        })
    }
    private fun addTabs(){
        tabLayout.addTab(tabLayout!!.newTab().setIcon(R.drawable.ic_baseline_photo_camera_24))
        tabLayout.addTab(tabLayout!!.newTab().setText("Chat"))
        tabLayout.addTab(tabLayout!!.newTab().setText("Status"))
        tabLayout.addTab(tabLayout!!.newTab().setText("Calls"))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }
}