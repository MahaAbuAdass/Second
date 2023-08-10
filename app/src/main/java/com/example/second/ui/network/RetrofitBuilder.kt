package com.example.second.ui.network

import com.example.second.ui.addresses.AddCustomerAddressRequest
import com.example.second.ui.addresses.DeleteCustomerAddressRequest
import com.example.second.ui.signin.LoginRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header

class RetrofitBuilder {

    private val apiService : ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://40.115.6.93:4525/")   // Replace with the actual API base URL  // base URL
            .addConverterFactory(GsonConverterFactory.create())
               .build()
          retrofit.create(ApiService::class.java)
    }



    suspend fun getAllProduct()=apiService.allProducts()

    suspend fun loginUser(loginRequest: LoginRequest?)=apiService.login(loginRequest)


    suspend fun getUserAddresses( auth: String)= apiService.getCustomerAddresses(auth)


    suspend fun editUserAddress(addCustomerAddressRequest: AddCustomerAddressRequest ,auth: String) =
        apiService.updateAddress(addCustomerAddressRequest,auth)

    suspend fun deleteCustomerAddress(
        deleteCustomerAddressRequest: DeleteCustomerAddressRequest,
        auth: String
    ) = apiService.deleteCustomerAddress(auth, deleteCustomerAddressRequest)


    suspend fun getOrders(auth: String) = apiService.getMyOrders(auth)

}