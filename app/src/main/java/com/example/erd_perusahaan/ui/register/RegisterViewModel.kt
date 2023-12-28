package com.example.erd_perusahaan.ui.register

import android.app.Application
import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.erd_perusahaan.database.RegisterEntity
import com.example.erd_perusahaan.database.RegisterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: RegisterRepository,private val application: Application): ViewModel() {

    private var userdata: String? = null

    var userDetailsLiveData = MutableLiveData<Array<RegisterEntity>>()


    @Bindable
    val inputUsername = MutableLiveData<String>()

    @Bindable
    val inputPassword = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    private val _navigateto = MutableLiveData<Boolean>()
    val navigateto: LiveData<Boolean>
        get() = _navigateto

    private val _errorToast = MutableLiveData<Boolean>()

    val errotoast: LiveData<Boolean>
        get() = _errorToast

    private val _errorToastUsername = MutableLiveData<Boolean>()

    val errotoastUsername: LiveData<Boolean>
        get() = _errorToastUsername

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    suspend fun sumbitButton() {
        Log.i("MyTag", "Inside Submit Button")
        if (inputUsername.value == null || inputEmail.value == null || inputPassword == null) {
            _errorToast.value = true
        } else {
            uiScope.launch {
                val userName= repository.getUsername(inputUsername.value!!)
                Log.i("MYtag",userName.toString()+"--------------")
                if (userName!=null){
                    _errorToastUsername.value= true
                    Log.i("MYTag","Inside if Not null")
                }else{
                    Log.i("MYTAG", userDetailsLiveData.value.toString() + "ASDFASDFASDFASDF")
                    Log.i("MYTAG", "OK im in")
                    val userName=inputUsername.value!!
                    val userEmail=inputEmail.value!!
                    val userPassword=inputPassword.value!!
                    _navigateto.value=true
                }
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
    }

    fun doneNavigating() {
        _navigateto.value = false
        Log.i("MYTAG", "Done navigating ")
    }

    fun donetoast() {
        _errorToast.value = false
        Log.i("MYTAG", "Done taoasting ")
    }

    fun donetoastUserName() {
        _errorToast.value = false
        Log.i("MYTAG", "Done taoasting  username")
    }
    private fun insert(user:RegisterEntity):Job=viewModelScope.launch {
        repository.insert(user)
    }
}