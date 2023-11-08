package com.example.viewpagersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagersample.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    companion object {
        const val ARG_OBJECT = "position"
        val cities = arrayOf(
            City("London", R.drawable.london, "First saw it in school textbooks. The incarnation of 'The West' to me. And definitely have to show it to Mom"),
            City("Seoul", R.drawable.seoul, "This country has been feeding me for the last 5 years. Now it's time to go and taste the food on site"),
            City("Edinburgh", R.drawable.edinburgh, "Want to visit on a rainy day. Or at least on a cloudy day."),
            City("Hamburg", R.drawable.hamburg, "Synonim of a bustling port-city for me. Want to feel the atmosphere")
        )
    }

    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cityCollectionAdapter = CityCollectionAdapter(this)
        viewPager = binding.viewPager
        viewPager.adapter = cityCollectionAdapter
        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout,  viewPager,true) { tab, position ->
            tab.text = cities[position].cityName
        }.attach()
    }


    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }
}