package com.example.respitrekdemoapp.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.respitrekdemoapp.network.Resource
import com.example.respitrekdemoapp.repository.LoginRepository
import com.example.respitrekdemoapp.responses.LoginResponse
import kotlinx.coroutines.launch

class AuthViewModel @ViewModelInject constructor(
        private val repository:LoginRepository

):ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
    get() = _loginResponse


    fun login(email:String,password:String)=viewModelScope.launch {
        _loginResponse.value = repository.getLoginResponse(email, password)
    }

    

}