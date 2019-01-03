package com.example.andhika.tolonginapp.model

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
    @SerializedName("total_donasi")
    val totalDonasi: String?,
    @SerializedName("tumnel")
    val tumnel: String?
)