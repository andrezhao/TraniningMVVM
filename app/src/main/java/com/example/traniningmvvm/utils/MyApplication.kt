package com.example.traniningmvvm.utils

import android.app.Application

open class MyApplication : Application() {
    open var counter: Int = 0
    open var aInt: Int by GlobalVariable(this, "aInt", 0)

    init {
        instance = this
    }

    companion object {
        private var instance: MyApplication? = null

        fun applicationContext(): MyApplication {
            return instance as MyApplication
        }
    }

    override fun onCreate() {
        super.onCreate()

    }
}
