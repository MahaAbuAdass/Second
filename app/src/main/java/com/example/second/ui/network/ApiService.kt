package com.example.second.ui.network

import com.example.second.ui.productapi.GetAllProductsResponse
import retrofit2.http.GET

interface ApiService {


    // Define all end points
@GET("api/Products/GetAll")
suspend fun allProducts(): GetAllProductsResponse

}