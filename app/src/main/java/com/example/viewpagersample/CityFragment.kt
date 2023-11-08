package com.example.viewpagersample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class CityFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf {
            it.containsKey(MainActivity.ARG_OBJECT)
        }?.apply {
            val position = getInt(MainActivity.ARG_OBJECT)

            val tvCityFact: TextView = view.findViewById(R.id.tv_city_fact)
            val ivCityImage: ImageView = view.findViewById(R.id.iv_city_image)
            with(MainActivity.cities[position]) {
                tvCityFact.text = cityFact
                ivCityImage.setImageResource(imageResourceId)
            }
        }
    }


}