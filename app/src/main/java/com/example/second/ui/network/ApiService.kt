package com.example.second.ui.network

import com.example.second.ui.addresses.AddCustomerAddressRequest
import com.example.second.ui.addresses.BooleanDataResponse
import com.example.second.ui.addresses.CustomerAddressResponse
import com.example.second.ui.addresses.DeleteCustomerAddressRequest
import com.example.second.ui.logout.LogoutRequestModel
import com.example.second.ui.orders.GetMyOrdersResponse
import com.example.second.ui.productapi.GetAllProductsResponse
import com.example.second.ui.signin.LoginRequest
import com.example.second.ui.signin.LoginResponse
import com.example.second.ui.signup.RegistrationRequestModel
import com.example.second.ui.signup.RegistrationResponseModel
import com.example.second.ui.userinfo.MyInfoResponse
import com.example.second.ui.userinfo.UpdateMyInfoRequest
import com.example.second.ui.userinfo.UpdateMyInfoResponse
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

    @POST("api/Customers/Register")
    suspend fun registration(
        @Body registrationRequestModel: RegistrationRequestModel?
    ): RegistrationResponseModel

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


    @GET("api/Orders/GetMyOrders")
    suspend fun getMyOrders(
        @Header("Authorization") auth: String
    ): GetMyOrdersResponse


    @POST("api/Customers/Logout")
    suspend fun logout
                (@Body logoutRequestModel: LogoutRequestModel?,
                 @Header("Authorization") auth: String?
    ): BooleanDataResponse

    @GET("api/Customers/GetMyInfo")
    suspend fun getMyInfo(
        @Header("Authorization") auth: String
    ): MyInfoResponse

    @POST("api/Customers/UpdateMyInfo")
    suspend fun updateMyInfo(
        @Body updateMyInfoRequest: UpdateMyInfoRequest,
        @Header("Authorization") auth: String
    ): UpdateMyInfoResponse
}