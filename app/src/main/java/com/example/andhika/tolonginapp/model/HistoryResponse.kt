package com.example.andhika.tolonginapp.model
import com.google.gson.annotations.SerializedName


data class HistoryResponse(
    @SerializedName("listbencana")
    val listbencana: List<ListHistory>?,
    @SerializedName("success")
    val success: Boolean?
)

data class ListHistory(
    @SerializedName("deskripsi_bencana")
    val deskripsiBencana: String?,
    @SerializedName("id_bencana")
    val idBencana: String?,
    @SerializedName("id_pengguna")
    val idPengguna: String?,
    @SerializedName("id_transaksi")
    val idTransaksi: String?,
    @SerializedName("judul_bencana")
    val judulBencana: String?,
    @SerializedName("nominal")
    val nominal: String?
)