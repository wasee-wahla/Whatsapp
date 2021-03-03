package com.notin.whatsapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.notin.whatsapp.fragments.CallsFragment
import com.notin.whatsapp.fragments.CameraFragment
import com.notin.whatsapp.fragments.ChatFragment
import com.notin.whatsapp.fragments.StatusFragment

class MainPagerAdapter(fm: FragmentManager, var tabCount: Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return CameraFragment.newInstance("0", "Camera")
            1 -> return ChatFragment.newInstance("1", "Chat")
            2 -> return StatusFragment.newInstance("2", "Status")
            else -> return CallsFragment.newInstance("3", "Calls")

        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}