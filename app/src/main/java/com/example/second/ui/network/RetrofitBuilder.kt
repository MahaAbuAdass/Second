package com.example.second.ui.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val apiService : ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://40.115.6.93:4525/")   // Replace with the actual API base URL  // base URL
            .addConverterFactory(GsonConverterFactory.create())
               .build()
          retrofit.create(ApiService::class.java)
    }



    suspend fun getAllProduct()=apiService.allProducts()

}