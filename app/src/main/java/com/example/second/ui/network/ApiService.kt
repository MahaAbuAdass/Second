package com.example.second.ui.network

import com.example.second.ui.addresses.AddCustomerAddressRequest
import com.example.second.ui.addresses.BooleanDataResponse
import com.example.second.ui.addresses.CustomerAddressResponse
import com.example.second.ui.addresses.DeleteCustomerAddressRequest
import com.example.second.ui.productapi.GetAllProductsResponse
import com.example.second.ui.signin.LoginRequest
import com.example.second.ui.signin.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {


    // Define all end points
@GET("api/Products/GetAll")
suspend fun allProducts(): GetAllProductsResponse


    @POST("api/Customers/Login")
    suspend fun login(@Body loginRequest: LoginRequest?): LoginResponse



    // add token in header for authorized api
    @GET("/api/Addresses/GetCustomerAddresses")
    suspend fun getCustomerAddresses( @Header("Authorization") auth: String): CustomerAddressResponse


    @POST("/api/Addresses/UpdateCustomerAddress")
    suspend fun updateAddress(
        @Body addCustomerAddressRequest: AddCustomerAddressRequest,
        @Header("Authorization") auth: String
    ): BooleanDataResponse


    @POST("api/Addresses/DeleteCustomerAddress")
    suspend fun deleteCustomerAddress(
        @Header("Authorization") auth: String,
        @Body deleteCustomerAddressRequest: DeleteCustomerAddressRequest?
    ): BooleanDataResponse

}