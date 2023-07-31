package com.example.second.ui.productapi


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetAllProductsResponse(

    @SerializedName("code") val code: Int,
    @SerializedName("data") val data: List<GetAllProductsData>,
    @SerializedName("error") val error: Error
) : Parcelable


@Parcelize
data class GetAllProductsData(

    @SerializedName("productId") val productId: Int,
    @SerializedName("nameEn") val nameEn: String,
    @SerializedName("nameAr") val nameAr: String,
    @SerializedName("categoryID") val categoryID: Int,
    @SerializedName("image") val image: String,
    @SerializedName("showOrder") val showOrder: Int,
    @SerializedName("price") val price: Double,
    @SerializedName("bundleLableInfoEn") val bundleLableInfoEn: String,
    @SerializedName("bundleLableInfoAr") val bundleLableInfoAr: String,
    @SerializedName("descriptionTitleEn") val descriptionTitleEn: String,
    @SerializedName("descriptionTitleAr") val descriptionTitleAr: String,
    @SerializedName("descriptionEn") val descriptionEn: String,
    @SerializedName("descriptionAr") val descriptionAr: String,
    @SerializedName("sizeTextEn") val sizeTextEn: String,
    @SerializedName("sizeTextAr") val sizeTextAr: String,
    @SerializedName("sizeFilterNumber") val sizeFilterNumber: Int,
    @SerializedName("brand") val brand: Int,
    @SerializedName("brandNameEn") val brandNameEn: String,
    @SerializedName("brandNameAr") val brandNameAr: String
) : Parcelable
