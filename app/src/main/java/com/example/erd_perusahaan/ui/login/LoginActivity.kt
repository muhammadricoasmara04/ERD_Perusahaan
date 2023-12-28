package com.example.erd_perusahaan.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.erd_perusahaan.R
import com.example.erd_perusahaan.ViewModelFactory
import com.example.erd_perusahaan.database.RegisterDatabase
import com.example.erd_perusahaan.database.RegisterRepository
import com.example.erd_perusahaan.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel:LoginViewModel
    private lateinit var repository: RegisterRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dao=RegisterDatabase.getInstance(application).registerDatabaseDao
        repository=RegisterRepository(dao)

    }
    private fun viewModelSetup(){
        val factory=ViewModelFactory(repository,application)
        viewModel=ViewModelProvider(this,factory).get(LoginViewModel::class.java)
    }
}