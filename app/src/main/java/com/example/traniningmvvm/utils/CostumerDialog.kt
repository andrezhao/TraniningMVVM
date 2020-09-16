package com.example.traniningmvvm.utils

import android.view.View
import androidx.annotation.LayoutRes
import com.example.traniningmvvm.R
import kotlinx.android.synthetic.main.progressesbar.view.*

class CostumerDialog : MyDialog() {


    override fun setUpLayoutId(): Int {
        this.mLayoutResId = R.layout.progressesbar
        return this.mLayoutResId
    }


    override fun convertView(holder: View, dialog: MyDialog?) {

    }

}