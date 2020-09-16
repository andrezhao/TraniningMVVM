package com.example.traniningmvvm.ui.activity.data

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.traniningmvvm.ui.activity.data.model.LoggedInUser
import com.example.traniningmvvm.ui.activity.ui.login.LoginResult
import com.example.traniningmvvm.utils.VolleyRequest
import com.google.gson.Gson
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource(context: Context) {

    private var mContext: Context = context
    private val TAG = "LoginDataSource"
    private var fakeUser: LoggedInUser = LoggedInUser("", "")
    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            getData()
            return Result.Success(fakeUser)

        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }

    private fun getData() {

        val url: String = "http://192.168.3.3:12306/userlogin"
        var request: StringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener {

                var local = Gson().fromJson(it, LoggedInUser::class.java)
                fakeUser = LoggedInUser(local.userId, local.displayName)
                Log.d(TAG, "getData: " + fakeUser.displayName)

            },
            Response.ErrorListener {

            }

        )
        VolleyRequest.getInstance(mContext).requestQueue.add(request)

    }
}