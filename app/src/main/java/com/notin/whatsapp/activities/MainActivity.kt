package com.notin.whatsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.notin.whatsapp.R
import com.notin.whatsapp.adapters.ChatAdapter
import com.notin.whatsapp.adapters.MainPagerAdapter
import com.notin.whatsapp.utils.CHAT_SCREEN_VALUE
import com.notin.whatsapp.vm.ChatViewModel
import com.notin.whatsapp.vmfactory.ChatViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {




    lateinit var mainPagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        addTabs()


        mainPagerAdapter = MainPagerAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = mainPagerAdapter




        viewPager.setCurrentItem(CHAT_SCREEN_VALUE)
        tabLayout.selectTab(tabLayout.getTabAt(CHAT_SCREEN_VALUE))
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position

                if(tab!!.position == 1){
                    fltngBtn.show()
                }else{
                    fltngBtn.hide()
                }
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