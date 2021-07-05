package com.example.respitrekdemoapp.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.respitrekdemoapp.R
import com.example.respitrekdemoapp.base.BaseFragment
import com.example.respitrekdemoapp.databinding.LoginBinding
import com.example.respitrekdemoapp.network.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: Fragment(R.layout.finallogin) {

    private val loginViewModel by viewModels<AuthViewModel>()


//    private var _binding: LoginBinding? = null
 //   private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // _binding= LoginBinding.bind(view)



//        binding.button.setOnClickListener {
//           val email= binding.email.text.toString().trim()
//           val password= binding.password.text.toString().trim()
//            loginViewModel.login(email,password)
//        }

        loginViewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success ->
                {
                    Toast.makeText(requireContext(),it.toString(),Toast.LENGTH_LONG).show()
                }

                is Resource.Error ->
                {
                    Toast.makeText(requireContext(),"Login Error",Toast.LENGTH_LONG).show()

                }
            }
        })






    }

}