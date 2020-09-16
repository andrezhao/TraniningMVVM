package com.example.traniningmvvm.ui.activity.ui.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.traniningmvvm.ui.activity.data.LoginDataSource
import com.example.traniningmvvm.ui.activity.data.LoginRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private var mContext: Context = context

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource(mContext)
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}