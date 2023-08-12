package com.example.second.ui.signup

import com.example.second.ui.signin.BaseError
import com.google.gson.annotations.SerializedName

data class RegistrationResponseModel(

    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: RegistrationData?,
    @SerializedName("error") val error: BaseError?
)

data class RegistrationData(

    @SerializedName("id") val id: Int?,
    @SerializedName("mobileNumber") val mobileNumber: String?,
    @SerializedName("token") val token: String?,
    @SerializedName("siteCode") val siteCode: String?
)


data class RegistrationRequestModel(


    var mobileNumber: String?,
    val password: String? = null,
    var siteCode: String? = "",
    var notificationKey: String? = "",
    var customerName: String = "",
    var businessName: String = ""

)