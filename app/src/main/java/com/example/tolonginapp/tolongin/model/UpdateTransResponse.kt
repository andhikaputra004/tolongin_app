package com.example.tolonginapp.tolongin.model
import com.google.gson.annotations.SerializedName


data class UpdateTransResponse(
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("fp")
    val fp: String?
)