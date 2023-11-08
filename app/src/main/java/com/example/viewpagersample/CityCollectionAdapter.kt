package com.example.viewpagersample

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CityCollectionAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = MainActivity.cities.size


    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int).
        val fragment = CityFragment()
        fragment.arguments = Bundle().apply {
            // The object is just an integer.
            putInt(MainActivity.ARG_OBJECT, position)
        }
        return fragment
    }

}
