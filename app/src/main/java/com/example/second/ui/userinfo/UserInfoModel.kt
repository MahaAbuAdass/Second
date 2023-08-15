package com.example.second.ui.userinfo

import com.example.second.ui.signin.BaseError
import com.google.gson.annotations.SerializedName


data class UpdateMyInfoResponse(
    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: UpdateMyInfoData?,
    @SerializedName("error") val error: BaseError?
)

data class UpdateMyInfoRequest(

    val name: String?,
    val email: String?,
    val site: String?,
    val businessType: String?,
    val businessName: String?
)



data class UpdateMyInfoData(

    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("mobileNumber") val mobileNumber: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("site") val site: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("businessType") val businessType: String?,
    @SerializedName("mSalsesRefrence") val mSalsesRefrence: String?,
    @SerializedName("isVerify") val isVerify: Boolean?
)



data class MyInfoResponse(

    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: MyInfoData?,
    @SerializedName("error") val error: Error?
)


data class MyInfoData(

    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("mobileNumber") val mobileNumber: String?,
    @SerializedName("businessName") val businessName: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("site") val site: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("businessType") val businessType: String?,
    @SerializedName("isVerify") val isVerify: Boolean?
)