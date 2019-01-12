package com.example.tolonginapp.tolongin.model
import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("email")
    val email: String?,
    @SerializedName("nama")
    val nama: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("telephone")
    val telephone: String?
)