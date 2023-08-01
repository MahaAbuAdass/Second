package com.example.second.ui.network

import com.example.second.ui.productapi.GetAllProductsResponse
import com.example.second.ui.signin.LoginRequest
import com.example.second.ui.signin.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {


    // Define all end points
@GET("api/Products/GetAll")
suspend fun allProducts(): GetAllProductsResponse


    @POST("api/Customers/Login")
    suspend fun login(@Body loginRequest: LoginRequest?): LoginResponse


}