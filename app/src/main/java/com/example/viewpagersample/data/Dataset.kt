package com.example.viewpagersample.data

import com.example.viewpagersample.R

class Dataset {
    companion object {
        const val ARG_OBJECT = "position"
        val cities = arrayOf(
            City(
                "London",
                R.drawable.london,
                "First saw it in school textbooks. The incarnation of 'The West' to me. And definitely have to show it to Mom"
            ),
            City(
                "Edinburgh",
                R.drawable.edinburgh,
                "Want to visit on a rainy day. Or at least on a cloudy day."
            ),
            City(
                "Seoul",
                R.drawable.seoul,
                "This country has been feeding me for the last 5 years. Now it's time to go and taste the food on site"
            ),
            City(
                "Hamburg",
                R.drawable.hamburg,
                "Synonim of a bustling port-city for me. Want to feel the atmosphere"
            )
        )
    }
}

