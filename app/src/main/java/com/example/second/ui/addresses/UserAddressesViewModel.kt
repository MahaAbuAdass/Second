package com.example.second.ui.addresses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.second.ui.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserAddressesViewModel : ViewModel() {
    private val retrofitBuilder = RetrofitBuilder()

    var DeleteCustomerAddressRequest : DeleteCustomerAddressRequest?=null

    private val _getAddresses = MutableLiveData<CustomerAddressResponse>()
    val getAddresses: LiveData<CustomerAddressResponse> = _getAddresses

    private val _isAddressDeleted = MutableLiveData<GetCustomerAddressesData?>()
    val isAddressDeleted: LiveData<GetCustomerAddressesData?> = _isAddressDeleted

    private val _getAddressesError = MutableLiveData<String>()
    val getAddressesError: LiveData<String> = _getAddressesError


    fun getUserAdresses(auth: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userAdresses = retrofitBuilder.getUserAddresses(auth)
                _getAddresses.postValue(userAdresses)
            } catch (e: Exception) {
                _getAddressesError.postValue(e.message.toString())
                // Handle error here if needed
            }
        }

    }

    suspend fun deleteCustomerAddress(
        getCustomerAddressesData: GetCustomerAddressesData, auth: String
    ) {
        val deleteCustomerAddressRequest =
            DeleteCustomerAddressRequest(getCustomerAddressesData.addressId ?: 0)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val deletedAddress =
                    retrofitBuilder.(DeleteCustomerAddressRequest, auth)
                if (deletedAddress.data == true)
                    _isAddressDeleted.postValue(getCustomerAddressesData)
            } catch (e: Exception) {
                _getAddressesError.postValue(e.message.toString())
            }
        }

    }

}
