package com.example.tolonginapp.tolongin.model
import com.google.gson.annotations.SerializedName


data class TransaksiResponse(
    @SerializedName("getTrans")
    val getTrans: List<GetTran>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("success")
    val success: Boolean?
)

data class GetTran(
    @SerializedName("bukti_pembayaran")
    val buktiPembayaran: String?,
    @SerializedName("id_bencana")
    val idBencana: String?,
    @SerializedName("id_pengguna")
    val idPengguna: String?,
    @SerializedName("id_transaksi")
    val idTransaksi: String?,
    @SerializedName("kode_unik")
    val kodeUnik: String?,
    @SerializedName("nominal")
    val nominal: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("tanggal_transaksi")
    val tanggalTransaksi: String?
)