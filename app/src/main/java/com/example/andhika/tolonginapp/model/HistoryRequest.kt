package com.example.andhika.tolonginapp.model
import com.google.gson.annotations.SerializedName


data class HistoryRequest(
    @SerializedName("id_pengguna")
    val idPengguna: Int?
)
