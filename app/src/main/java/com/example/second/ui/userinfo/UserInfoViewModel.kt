package com.example.second.ui.userinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.second.ui.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserInfoViewModel : ViewModel() {
    private var retrofitBuilder = RetrofitBuilder()

    private val _getInfoResponse = MutableLiveData<MyInfoResponse?>()
    val getInfoResponse: LiveData<MyInfoResponse?> = _getInfoResponse

    private val _getInfoError = MutableLiveData<String?>()
    val getInfoError: LiveData<String?> = _getInfoError

    private val _updateInfoResponse = MutableLiveData<UpdateMyInfoResponse?>()
    val updateInfoResponse: LiveData<UpdateMyInfoResponse?> = _updateInfoResponse

    private val _updateInfoError = MutableLiveData<String?>()
    val updateInfoError: LiveData<String?> = _updateInfoError


    suspend fun getUserInfoDate(auth: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = retrofitBuilder.getUserInfo(auth)
            try {
                _getInfoResponse.postValue(response)
            } catch (e: Exception) {
                _getInfoError.postValue(e.message)
            }
        }
    }

    suspend fun updateUserInfo(updateMyInfoRequest: UpdateMyInfoRequest,auth: String){
        viewModelScope.launch(Dispatchers.IO){
            val response2= retrofitBuilder.updateInfo(updateMyInfoRequest,auth)
            try {
                _updateInfoResponse.postValue(response2)
            }
            catch (e:Exception){
                _updateInfoError.postValue(e.message.toString())
            }

        }

    }

}