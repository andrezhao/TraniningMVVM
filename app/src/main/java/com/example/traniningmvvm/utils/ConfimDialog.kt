package com.example.traniningmvvm.utils

import android.view.View
import com.example.traniningmvvm.R
import kotlinx.android.synthetic.main.cofrimdialog.view.*

class ConfimDialog : MyDialog() {
    private lateinit var myCallBack: CallBack
    override fun setUpLayoutId(): Int {
        return R.layout.cofrimdialog
    }

    open fun setMyCallback(callBack: CallBack) {
        this.myCallBack = callBack

    }

    override fun convertView(holder: View, dialog: MyDialog?) {
        holder.dialog_ok_bt.setOnClickListener {
            myCallBack.okButton()
        }

        holder.dialog_cancel_bt.setOnClickListener {
            myCallBack.cancelButton()
        }


    }

    interface CallBack {

        fun okButton()
        fun cancelButton()
    }
}