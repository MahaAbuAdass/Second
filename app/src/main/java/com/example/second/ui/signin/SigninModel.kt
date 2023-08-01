package com.example.second.ui.signin

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class LoginRequest(

    @SerializedName("mobileNumber") val mobileNumber: String,
    @SerializedName("password") val password: String,
    @SerializedName("notificationKey") var notificationKey: String? = ""
)


data class LoginResponse(
    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: LoginData?,
    @SerializedName("error") val baseError: BaseError?
)

data class LoginData(

    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("phoneNumber") val phoneNumber: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("token") val token: String?
)

@Parcelize
data class BaseError(

    @SerializedName("errors") val errors: String,
    @SerializedName("message") val message: String,
    @SerializedName("detail") val detail: String,
    @SerializedName("innerException") val innerException: String
) : Parcelable