package com.example.andhika.tolonginapp.model
import com.google.gson.annotations.SerializedName


data class RegisterRequest(
    @SerializedName("nama_donatur")
    val namaDonatur: String?,
    @SerializedName("telepon_donatur")
    val teleponDonatur: String?
)