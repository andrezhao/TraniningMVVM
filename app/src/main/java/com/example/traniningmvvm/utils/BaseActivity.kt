package com.example.traniningmvvm.utils

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.traniningmvvm.ui.activity.MainActivity


abstract class BaseActivity : AppCompatActivity() {
    private var exitTime: Long = 0
    private val TAG = "BaseActivity"
    private var appManager = AppManager.instance
    protected var application = MyApplication.applicationContext()
    protected lateinit var mContext: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initParmas(intent.extras)
        setContentView(initLayout())
        initView()
        initData()
        appManager.addActivity(this)
        mContext = this
    }


    // 网络监听
    // 权限监听
    abstract fun initParmas(bundle: Bundle?)//getIntent() 传参  这个问号很关键 代表这个参数可以为空
    abstract fun initLayout(): Int //设置布局layout
    abstract fun initView() //初始化view
    abstract fun initData() //数据操作

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        // 监听返回键，点击两次退出程序
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() === KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 5000) {
                Toast.makeText(applicationContext, "再按一次退出程序", Toast.LENGTH_LONG).show()
                exitTime = System.currentTimeMillis()
            } else {
                AppManager.instance.exitSystem()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onDestroy() {
        AppManager.instance.removeActivity(this);
        super.onDestroy()
    }

    open fun OnIntent(clz: Class<out Activity>) {
        val intent = Intent(this, clz)
        startActivity(intent)
    }

    fun startActivity(clz: Class<*>, bundle: Bundle?) {
        val intent = Intent()
        intent.setClass(mContext, clz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    fun showToast(msg: String) {
        kotlin.run { Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show() }

    }


}