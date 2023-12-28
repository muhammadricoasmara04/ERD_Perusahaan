package com.example.erd_perusahaan

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.erd_perusahaan.database.RegisterRepository
import com.example.erd_perusahaan.ui.login.LoginViewModel
import com.example.erd_perusahaan.ui.register.RegisterViewModel

class ViewModelFactory( val repository: RegisterRepository, val application: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java)-> {
                return RegisterViewModel(repository, application) as T
            }
                modelClass.isAssignableFrom(LoginViewModel::class.java)->{
                return LoginViewModel(repository, application) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}