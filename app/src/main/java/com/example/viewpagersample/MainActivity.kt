package com.example.viewpagersample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagersample.databinding.ActivityMainBinding
import com.example.viewpagersample.transformers.DefaultPageTransformer
import com.example.viewpagersample.transformers.DepthPageTransformer
import com.example.viewpagersample.transformers.ZoomOutPageTransformer
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var citiesViewPager: ViewPager2
    private val citiesPagerAdapter by lazy {
        CitiesPagerAdapter(Dataset.cities, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            citiesViewPager = viewPager
            citiesViewPager.adapter = citiesPagerAdapter
            citiesViewPager.setPageTransformer(DepthPageTransformer())
            val citiesTabLayout = tabLayout
            TabLayoutMediator(citiesTabLayout, citiesViewPager)
            { tab, position ->
                tab.text = Dataset.cities[position].cityName
            }.attach()
        }


    }

    override fun onBackPressed() {
        val currentTab = binding.tabLayout.selectedTabPosition
        if (currentTab > 0) {
            binding.tabLayout.getTabAt(currentTab - 1)?.select()
        } else {
            super.onBackPressed()
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.select_transformer_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_depth -> {
                citiesViewPager.setPageTransformer(DepthPageTransformer())
                true
            }

            R.id.action_zoom_out -> {
                citiesViewPager.setPageTransformer(ZoomOutPageTransformer())
                true
            }

            R.id.action_default -> {
                citiesViewPager.setPageTransformer(DefaultPageTransformer())
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}