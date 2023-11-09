package com.example.viewpagersample.transformers

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class DefaultPageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        // Примените здесь трансформацию, которая будет имитировать поведение по умолчанию
        // Например, вы можете использовать анимации масштабирования, вращения и перемещения, чтобы имитировать стандартное поведение
    }
}