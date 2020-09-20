package com.example.traniningmvvm.utils

import android.util.Log
import com.example.traniningmvvm.BuildConfig

object LogUtils {

    val logFlag = BuildConfig.LOGGING //gradleに記載

    fun d(tag: String, msg: String) {
        if (logFlag) {
            Log.d(tag, msg)
        }
    }


}