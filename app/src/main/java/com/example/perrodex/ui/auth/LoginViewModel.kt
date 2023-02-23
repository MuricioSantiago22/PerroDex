package com.example.perrodex.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perrodex.model.User
import com.example.perrodex.network.ApiResponseStatus
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
    get() = _user

    private val _status = MutableLiveData<ApiResponseStatus<User>>()
    val status: LiveData<ApiResponseStatus<User>>
    get() = _status

    private val loginRepository = LoginRepository()

    fun signUp(email: String, password: String, passwordConfirmation: String) {

        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus(loginRepository.signUp(email, password, passwordConfirmation))
        }
    }
    private fun handleResponseStatus(apiResponseStatus: ApiResponseStatus<User>){
        if (apiResponseStatus is ApiResponseStatus.Success){
            _user.value = apiResponseStatus.data
        }
        _status.value = apiResponseStatus
    }

}