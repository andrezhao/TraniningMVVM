package com.example.traniningmvvm.utils

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class PageTransformers(private val type: Int) : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        when (type) {
            1 -> stackType(page, position)

            2 -> standType(page, position)

            else -> cubInTransformer(page, position)


        }
    }

    fun stackType(page: View, position: Float) {
        if (position < -1) { // [-Infinity,-1)
            page.translationX = (0f);
        } else if (position <= 0) { // [-1,0]
            page.translationX = (0f);
        } else if (position <= 1) { // (0,1]
            page.translationX = (-page.getWidth() * position);
        } else { // (1,+Infinity]
            page.translationX = (0f);
        }
    }

    fun standType(page: View, position: Float) {
        if (position < -1) { // [-Infinity,-1)
            page.pivotX = (0f);
            page.scaleX = (1f);
            page.translationX = (0f);
        } else if (position <= 0) { // [-1,0]
            page.pivotX = (0f);
            page.translationX = (-position * page.getWidth());
            page.scaleX = (position + 1);
        } else if (position <= 1) { // (0,1]
            page.pivotX = (page.getWidth().toFloat());
            page.translationX = (-position * page.getWidth());
            page.scaleX = (1 - position);
        } else { // (1,+Infinity]
            page.pivotX = (0f);
            page.scaleX = (1f);
            page.translationX = (0f);
        }
    }

    fun cubInTransformer(page: View, position: Float) {
        page.setCameraDistance(page.getWidth().toFloat() * 20);
        if (position < -1) { // [-Infinity,-1)
            page.setPivotX(0f);
            page.setPivotY(0f);
            page.setRotationY(0f);
        } else if (position <= 0) { // [-1,0]
            page.setPivotX(page.getWidth().toFloat());
            page.setPivotY(0f);
            page.setRotationY(-90f * position);
        } else if (position <= 1) { // (0,1]
            page.setPivotX(0f);
            page.setPivotY(0f);
            page.setRotationY(-90f * position);
        } else { // (1,+Infinity]
            page.setPivotX(0f);
            page.setPivotY(0f);
            page.setRotationY(0f);
        }
    }


}

