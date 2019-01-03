package com.example.andhika.tolonginapp.model
import com.google.gson.annotations.SerializedName


data class ChangePasswordResponse(
    @SerializedName("message")
    val message: String?
)