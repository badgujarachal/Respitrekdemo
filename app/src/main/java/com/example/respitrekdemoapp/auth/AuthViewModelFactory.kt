package com.example.respitrekdemoapp.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.respitrekdemoapp.repository.LoginRepository

class AuthViewModelFactory(
     val loginRepository: LoginRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return  AuthViewModel(loginRepository) as T
    }
}


