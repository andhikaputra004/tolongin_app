package com.example.tolonginapp.tolongin.model
import com.google.gson.annotations.SerializedName


data class HistoryRequest(
    @SerializedName("id_pengguna")
    val idPengguna: Int?
)
