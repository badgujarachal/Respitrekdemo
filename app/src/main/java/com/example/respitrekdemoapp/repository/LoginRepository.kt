package com.example.respitrekdemoapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.respitrekdemoapp.network.AuthApi
import com.example.respitrekdemoapp.network.Resource
import com.example.respitrekdemoapp.responses.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(
        val api:AuthApi
) {
 suspend fun getLoginResponse(email:String,password:String)=api.login(email,password)
}