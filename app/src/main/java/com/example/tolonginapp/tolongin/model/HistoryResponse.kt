package com.example.tolonginapp.tolongin.model

import com.google.gson.annotations.SerializedName
import java.util.*


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
    val nominal: String?,
    @SerializedName("tanggal_transaksi")
    val tanggalTransaksi: String?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("nomer_rekening")
    val nomerRek: String?,
    @SerializedName("nama_penggalangdana")
    val namaPenggalangdana: String?,
    @SerializedName("nama_bank")
    val namaBank: String?
)