package com.example.second.ui.orders


import android.os.Parcelable
import com.example.second.ui.signin.BaseError
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize

data class GetMyOrdersResponse(

    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: List<MyOrdersData>?,
    @SerializedName("error") val error: BaseError?
) : Parcelable

@Parcelize

data class MyOrdersData(

    @SerializedName("orderId") val orderId: Int?,
    @SerializedName("source") val source: Int?,
    @SerializedName("status") val status: Int?,
    @SerializedName("notes") val notes: String?,
    @SerializedName("totalPrice") val totalPrice: Double?,
    @SerializedName("createDate") val createDate: String?,
    @SerializedName("addressId") val addressId: Int?,
    @SerializedName("addressCity") val addressCity: String?,
    @SerializedName("address1") val address1: String?,
    @SerializedName("address2") val address2: String?,
    @SerializedName("addressLongitude") val addressLongitude: String?,
    @SerializedName("addressLatitude") val addressLatitude: String?,
    @SerializedName("contactPersonName") val contactPersonName: String?,
    @SerializedName("contactPersonPhone") val contactPersonPhone: String?,
    @SerializedName("products") val products: List<GetAllProductsData>?
) : Parcelable


@Parcelize
data class GetAllProductsData(

    @SerializedName("productId") val productId: Int?,
    @SerializedName("nameEn") val nameEn: String?,
    @SerializedName("nameAr") val nameAr: String?,
    @SerializedName("categoryID") val categoryID: Int?,
    @SerializedName("image") val image: String?,
    @SerializedName("showOrder") val showOrder: Int?,
    @SerializedName("price") val price: Double?,
    @SerializedName("bundleLableInfoEn") val bundleLableInfoEn: String?,
    @SerializedName("bundleLableInfoAr") val bundleLableInfoAr: String?,
    @SerializedName("descriptionTitleEn") val descriptionTitleEn: String?,
    @SerializedName("descriptionTitleAr") val descriptionTitleAr: String?,
    @SerializedName("descriptionEn") val descriptionEn: String?,
    @SerializedName("descriptionAr") val descriptionAr: String?,
    @SerializedName("sizeTextEn") val sizeTextEn: String?,
    @SerializedName("sizeTextAr") val sizeTextAr: String?,
    @SerializedName("sizeFilterNumber") val sizeFilterNumber: Int?,
    @SerializedName("brand") val brand: Int?,
    @SerializedName("brandNameEn") val brandNameEn: String?,
    @SerializedName("brandNameAr") val brandNameAr: String?
) : Parcelable {
    @IgnoredOnParcel
    var quantity: Int = 0
}

