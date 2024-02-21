package com.example.viewpagersample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.viewpagersample.databinding.FragmentCityBinding
import com.example.viewpagersample.model.City

class CityFragment : Fragment(R.layout.fragment_city) {
    private var binding: FragmentCityBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentCityBinding.bind(view)
        val city = arguments?.getParcelable<City>(CITY_INDEX) as City
        binding?.let {
            with(it) {
                tvCityFact.text = city.cityFact
                ivCityImage.setImageResource(city.imageResourceId)
                ivCityImage.setOnClickListener { searchOnGoogle(city.cityName) }
            }

        }

    }

    private fun searchOnGoogle(searchWord: String) {
        val webPage = Uri.parse("https://www.google.com/search?q=$searchWord")
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        activity?.startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        const val CITY_INDEX = "cityIndex"
        fun newInstance(city: City): CityFragment {
            return CityFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(CITY_INDEX, city)
                }
            }
        }
    }
}