package com.example.traniningmvvm.ui.activity


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginLeft
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.traniningmvvm.R
import com.example.traniningmvvm.ui.activity.ui.login.LoginActivity
import com.example.traniningmvvm.ui.lunch.LunchOneFragment
import com.example.traniningmvvm.ui.lunch.LunchThreeFragment
import com.example.traniningmvvm.ui.lunch.LunchTwoFragment
import com.example.traniningmvvm.utils.AppManager
import com.example.traniningmvvm.utils.BaseActivity
import com.example.traniningmvvm.utils.PageTransformers
import kotlinx.android.synthetic.main.activity_lunch.*
import kotlin.math.floor

class LunchActivity : BaseActivity() {

    val TAG: String = LunchActivity::class.java.getSimpleName()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (application.aInt == 0) {
            application.aInt = 1
            initLayout()
            initView()

        } else {
            this.finish()
            OnIntent(LoginActivity::class.java)
        }
    }

    override fun initParmas(bundle: Bundle?) {

    }

    override fun initLayout(): Int {
        return R.layout.activity_lunch
    }

    override fun initView() {
        viewPager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 3
            override fun createFragment(position: Int) =
                when (position) {
                    0 -> LunchOneFragment()
                    1 -> LunchTwoFragment()
                    2 -> LunchThreeFragment()
                    else -> LunchOneFragment()
                }

        }
        viewPager2.currentItem = 0
        viewPager2.setPageTransformer(PageTransformers(3))
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                pageIndicate(position)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })
        button.setOnClickListener {
            it.animate().alpha(0f)
            OnIntent(MainActivity::class.java)
        }

    }


    override fun initData() {

    }

    fun pageIndicate(position: Int) {
        when (position) {
            0 -> {
                imageView1.setImageResource(R.drawable.ic_baseline_radio_button_unchecked_24)
                imageView2.setImageResource(R.drawable.ic_baseline_brightness_1_24)
                imageView3.setImageResource(R.drawable.ic_baseline_brightness_1_24)
                button.visibility = View.GONE
            }
            1 -> {
                imageView2.setImageResource(R.drawable.ic_baseline_radio_button_unchecked_24)
                imageView1.setImageResource(R.drawable.ic_baseline_brightness_1_24)
                imageView3.setImageResource(R.drawable.ic_baseline_brightness_1_24)
                button.visibility = View.GONE
            }
            2 -> {
                imageView3.setImageResource(R.drawable.ic_baseline_radio_button_unchecked_24)
                imageView2.setImageResource(R.drawable.ic_baseline_brightness_1_24)
                imageView1.setImageResource(R.drawable.ic_baseline_brightness_1_24)
                button.visibility = View.VISIBLE
            }
            else -> LunchOneFragment()
        }

    }


}