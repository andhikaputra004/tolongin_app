package com.example.tolonginapp.tolongin.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("datapengguna")
    val datapengguna: Datapengguna?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("role")
    val role: String?,
    @SerializedName("success")
    val success: Boolean?
)

data class Datapengguna(
    @SerializedName("email")
    val email: String,
    @SerializedName("id_pengguna")
    val idPengguna: String,
    @SerializedName("id_role")
    val idRole: String,
    @SerializedName("nama")
    val nama: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("status")
    val status: String
)