package com.example.erd_perusahaan.ui.register

import android.app.Application
import androidx.databinding.Bindable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.erd_perusahaan.database.RegisterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class RegisterViewModel(private val repository: RegisterRepository,private val application: Application): ViewModel() {
    @Bindable
    val inputUsername= MutableLiveData<String>()

    @Bindable
    val inputPassword= MutableLiveData<String>()
     @Bindable
    val inputEmail= MutableLiveData<String>()
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)



    suspend fun sumbitButton(){
        if (inputUsername.value==null ||inputEmail.value==null||inputPassword==null){

    }else{
        }
        val userName=repository.getUsername(inputUsername.value!!)
        if (userName!=null){
        }else{
            val username=inputUsername.value!!
            val email=inputUsername.value!!
            val password=inputPassword.value!!


        }
    }
}