package com.example.traniningmvvm.ui.my

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.traniningmvvm.R
import com.example.traniningmvvm.utils.BaseFragment

class MyFragment : BaseFragment() {

    private lateinit var viewModel: MyViewModel

    override fun layoutRID(): Int {
        return R.layout.my_fragment
    }

    override fun initView(view: View?) {
        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
    }

    override fun initData() {

    }


}