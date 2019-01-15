package com.example.tolonginapp.tolongin.model
import com.google.gson.annotations.SerializedName


data class UpdateTransRequest(
    @SerializedName("id_transaksi")
    val idTransaksi: Int?,
    @SerializedName("bukti_pembayaran")
    val buktiPembayaran: String?,
    @SerializedName("encoded_image")
    val encodeImage: String?
    )