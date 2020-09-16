package com.example.traniningmvvm.utils

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley


class VolleyRequest private constructor(context: Context) {

    private lateinit var mContext: Context

    companion object {
        private var INSTANCE: VolleyRequest? = null
        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this) {
                VolleyRequest(context).also {
                    INSTANCE = it
                }
            }
    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

}


