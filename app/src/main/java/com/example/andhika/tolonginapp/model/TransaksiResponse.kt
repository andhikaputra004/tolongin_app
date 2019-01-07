package com.example.andhika.tolonginapp.model
import com.google.gson.annotations.SerializedName


data class TransaksiResponse(
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?
)