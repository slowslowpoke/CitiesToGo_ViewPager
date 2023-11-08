package com.example.viewpagersample

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagersample.data.City
import com.example.viewpagersample.data.Dataset

class CityCollectionAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = Dataset.cities.size


    override fun createFragment(position: Int): Fragment {

        val fragment = CityFragment()
        fragment.arguments = Bundle().apply {
            putInt(Dataset.ARG_OBJECT, position)
        }
        return fragment
    }

}
