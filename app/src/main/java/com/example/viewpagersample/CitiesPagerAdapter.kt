package com.example.viewpagersample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagersample.model.City

class CitiesPagerAdapter(
    private val citiesList: List<City>,
    fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = citiesList.size

    override fun createFragment(position: Int): Fragment {
        return CityFragment.newInstance(citiesList[position])
    }

}