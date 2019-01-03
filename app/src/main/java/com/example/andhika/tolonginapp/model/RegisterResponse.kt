package com.example.andhika.tolonginapp.model
import com.google.gson.annotations.SerializedName


data class RegisterResponse(
    @SerializedName("datadonatur")
    val datadonatur: Datadonatur?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?
)

data class Datadonatur(
    @SerializedName("foto_donatur")
    val fotoDonatur: String?,
    @SerializedName("id_donatur")
    val idDonatur: String?,
    @SerializedName("id_pengguna")
    val idPengguna: String?,
    @SerializedName("nama_donatur")
    val namaDonatur: String?,
    @SerializedName("telepon_donatur")
    val teleponDonatur: String?
)