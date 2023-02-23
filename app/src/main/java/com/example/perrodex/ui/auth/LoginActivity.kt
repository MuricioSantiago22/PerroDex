package com.example.perrodex.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.example.perrodex.R
import com.example.perrodex.databinding.ActivityLoginBinding
import com.example.perrodex.network.ApiResponseStatus

class LoginActivity : AppCompatActivity(), LoginFragment.LoginFragmentActions, SignUpFragment.SignUpFragmentActions {

    private val loginViewModel : LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel.status.observe(this){
            status ->

            when(status){
                is ApiResponseStatus.Error -> {
                    loadingWheel.visibility = View.GONE
                    Toast.makeText(this, status.messageId,Toast.LENGTH_SHORT)

                }
                is ApiResponseStatus.Loading -> {
                    loadingWheel.visibility = View.ç
                }
                is ApiResponseStatus.Success -> {}
            }

        }
    }

    override fun onRegisterButtonClick() {
        findNavController(R.id.nav_host_fragment)
            .navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
    }

    override fun onSignUpFieldsValidated(
        email: String,
        password: String,
        passwordConfirmation: String
    ) {

        loginViewModel.signUp(email, password, passwordConfirmation)

    }
}