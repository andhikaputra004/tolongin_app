package com.example.tolonginapp.tolongin.model

import com.google.gson.annotations.SerializedName

data class ListBencanaResponse(
    @SerializedName("listbencana")
    val listbencana: List<Listbencana>?,
    @SerializedName("success")
    val success: Boolean?
)

data class Listbencana(
    @SerializedName("deskripsi_bencana")
    val deskripsiBencana: String?,
    @SerializedName("id_bencana")
    val idBencana: String?,
    @SerializedName("judul_bencana")
    val judulBencana: String?,
    @SerializedName("nama_penggalangdana")
    val namaPenggalangdana: String?,
    @SerializedName("nomer_rekening")
    val nomerRekening: String?,
    @SerializedName("total_donasi")
    val totalDonasi: Double?,
    @SerializedName("tumnel")
    val tumnel: String?
)