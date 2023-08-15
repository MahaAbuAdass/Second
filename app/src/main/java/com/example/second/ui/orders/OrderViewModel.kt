package com.example.second.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.second.ui.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {
    private val retrofitBuilder = RetrofitBuilder()

    private val _getOrders = MutableLiveData<List<MyOrdersData>?>()
    val getOrders : LiveData<List<MyOrdersData>?> = _getOrders

    private val _getOrdersError = MutableLiveData<String>()
    val getOrdersError : LiveData<String> = _getOrdersError

    private val _getProducts = MutableLiveData<List<GetAllProductsData>?>()
    val getProducts : LiveData<List<GetAllProductsData>?> = _getProducts

    fun getOrders(auth : String){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val userOrders = retrofitBuilder.getOrders(auth)
                _getOrders.postValue(userOrders.data)
            } catch (e:Exception) {
                _getOrdersError.postValue(e.message.toString())
            }
        }

    }


}