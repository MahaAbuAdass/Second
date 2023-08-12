package com.example.second.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.second.ui.network.RetrofitBuilder
import com.example.second.ui.signin.BaseError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class RegistrationViewModel : ViewModel() {
    private val retrofitBuilder = RetrofitBuilder()

    private val registrationRequestModel : RegistrationRequestModel?=null

    private val _registrationRespones = MutableLiveData<RegistrationData?>()
    val registrationResponse : LiveData<RegistrationData?> = _registrationRespones

    private val _errorResponse = MutableLiveData<BaseError?>()
    val errorResponse : LiveData<BaseError?> = _errorResponse


    suspend fun callRegistrationAPI (registrationRequestModel : RegistrationRequestModel){

        viewModelScope.launch (Dispatchers.IO){
            retrofitBuilder.registerUser(registrationRequestModel).apply {
                try {
                    _registrationRespones.postValue(data)
                } catch (e: Exception){
                    _errorResponse.postValue(error)
                }
            }
        }

    }

}