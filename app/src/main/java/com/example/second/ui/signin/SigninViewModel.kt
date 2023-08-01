package com.example.second.ui.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.second.ui.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SigninViewModel : ViewModel() {

    // to be able to use them inside the fun login below
    private var loginResponsess: LoginResponse? = null
    private val retrofitBuilder = RetrofitBuilder()

    private val _loginRespone = MutableLiveData<LoginData?>()
    val loginResponse: LiveData<LoginData?> = _loginRespone

    private val _loginResponeError = MutableLiveData<BaseError?>()
    val loginResponseError: LiveData<BaseError?> = _loginResponeError

    suspend fun login(loginRequest: LoginRequest?) {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                loginResponsess = retrofitBuilder.loginUser(loginRequest)
                _loginRespone.postValue(loginResponsess?.data)
            } catch (e: Exception) {
                _loginResponeError.postValue(loginResponsess?.baseError)
                // Handle error here if needed
            }
        }
    }


}

