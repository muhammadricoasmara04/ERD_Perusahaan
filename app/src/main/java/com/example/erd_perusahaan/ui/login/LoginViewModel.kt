package com.example.erd_perusahaan.ui.login

import android.app.Application
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.erd_perusahaan.database.RegisterRepository

class LoginViewModel(private val repository: RegisterRepository,application: Application):
    ViewModel() {
        val users=repository.users


    @Bindable
    val inputUsername= MutableLiveData<String>()

    @Bindable
    val inputPassword=MutableLiveData<String>()

    fun loginButton(){

    }
    }