package com.example.traniningmvvm.utils

import android.app.Activity
import java.util.*


class AppManager {

    var activityStack: Stack<Activity> = Stack()

    companion object {
        val instance: AppManager by lazy { AppManager() }
    }

    fun addActivity(activity: Activity) {

        activityStack.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    fun getCurrentActivity(): Activity {

        return activityStack.lastElement()
    }

    fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()

    }

    // 遍历所有Activity并finish
    fun exitSystem() {
        for (activity in activityStack) {
            activity?.finish()
        }
        // 退出进程
        System.exit(0)
    }

}

//    fun  <T> goActivity(context: Context,clazz: Class<T>){
//        val intent = Intent()
//        intent.setClass(context,clazz.javaClass)
//        startActivity(intent)


// 添加activity
// 删除指定activti
// 获取当前Activity
// 清除所有activty
//退出程序

