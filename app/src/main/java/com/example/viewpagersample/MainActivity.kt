package com.example.viewpagersample

import com.example.viewpagersample.transformers.ZoomOutPageTransformer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagersample.data.City
import com.example.viewpagersample.data.Dataset
import com.example.viewpagersample.databinding.ActivityMainBinding
import com.example.viewpagersample.transformers.DepthPageTransformer
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {


    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cityCollectionAdapter = CityCollectionAdapter(this)
        viewPager = binding.viewPager
        viewPager.apply {
            adapter = cityCollectionAdapter
            //setPageTransformer(ZoomOutPageTransformer())
            setPageTransformer(DepthPageTransformer())

        }


        val tabLayout = binding.tabLayout

        TabLayoutMediator(tabLayout, viewPager, true) { tab, position ->
            tab.text = Dataset.cities[position].cityName
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