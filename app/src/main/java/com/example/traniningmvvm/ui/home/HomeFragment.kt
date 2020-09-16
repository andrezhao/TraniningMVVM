package com.example.traniningmvvm.ui.home

import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.traniningmvvm.R
import com.example.traniningmvvm.utils.BaseFragment

class HomeFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun layoutRID(): Int {
        return R.layout.fragment_home
    }

    override fun initView(view: View?) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val textView: TextView =
            if (view != null) view.findViewById(R.id.text_home) else throw NullPointerException("Expression 'view' must not be null")
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        //showProgressDialog()
        showConfirmDialog()

    }

    override fun initData() {

    }

    override fun cancelButton() {
        super.cancelButton()
        disMissDialog()
    }

    override fun okButton() {
        super.okButton()
        disMissDialog()


    }
}