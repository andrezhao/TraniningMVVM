package com.example.traniningmvvm.utils

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


abstract class BaseFragment : Fragment(), ConfimDialog.CallBack {

    private var mActivity: BaseActivity? = null
    private lateinit var dialogFragment: CostumerDialog
    private lateinit var confirmDialogFragment: ConfimDialog
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = View.inflate(activity, layoutRID(), null)
        initView(view)
        initData()
        return view
    }

    fun showConfirmDialog() {
        confirmDialogFragment = ConfimDialog()
        confirmDialogFragment.setSize(400, 200)
        confirmDialogFragment.setMargin(20)
        confirmDialogFragment.isCancelable = true
        confirmDialogFragment.setUpLayoutId()
        confirmDialogFragment?.show(requireActivity().supportFragmentManager, "dialog")
        confirmDialogFragment.setMyCallback(this)
    }

    fun showProgressDialog() {
        dialogFragment = CostumerDialog()
        dialogFragment.setSize(200, 200)
        dialogFragment.setMargin(20)
        dialogFragment.isCancelable = true
        dialogFragment.setUpLayoutId()
        dialogFragment?.show(requireActivity().supportFragmentManager, "dialog")
    }

    fun disMissDialog() {
        if (confirmDialogFragment != null) confirmDialogFragment.dismiss()
    }


    protected abstract fun layoutRID(): Int

    protected abstract fun initView(view: View?)

    protected abstract fun initData(
    )

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        this.mActivity = activity as BaseActivity
    }

    //获取宿主Activity
    protected open fun getHoldingActivity(): BaseActivity? {
        return mActivity
    }

    override fun okButton() {

    }

    override fun cancelButton() {

    }
}


