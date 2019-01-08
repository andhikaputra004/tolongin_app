package com.example.tolonginapp.tolongin.model
import com.google.gson.annotations.SerializedName


data class TransaksiRequest(
    @SerializedName("id_bencana")
    val idBencana: Int?,
    @SerializedName("id_pengguna")
    val idPengguna: Int?,
    @SerializedName("nominal")
    val nominal: Int?,
    @SerializedName("kode_unik")
    val kodeUnik: Int?
)