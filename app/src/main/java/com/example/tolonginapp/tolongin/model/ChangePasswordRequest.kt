package com.example.tolonginapp.tolongin.model
import com.google.gson.annotations.SerializedName


data class ChangePasswordRequest(
    @SerializedName("id_pengguna")
    val idPengguna: Int?,
    @SerializedName("password")
    val password: String?
)