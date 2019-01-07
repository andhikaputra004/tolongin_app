package com.example.andhika.tolonginapp.network

import com.example.andhika.tolonginapp.model.*
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface NetworkService {
    @POST("loginmobile")
    fun loginMoble(@Body request: LoginRequest): Observable<LoginResponse>

    @POST("Register_Donatur")
    fun registerMobile(@Body request: RegisterRequest) : Observable<RegisterResponse>

    @GET("List_bencana")
    fun listBencana() : Observable<ListBencanaResponse>

    @PUT("ganti_password")
    fun changePassword(@Body request : ChangePasswordRequest) : Observable<ChangePasswordResponse>

    @POST("getHistory")
    fun getHistory(@Body request: HistoryRequest) : Observable<HistoryResponse>

    @POST("do_transaksi")
    fun doTransaksi(@Body request: TransaksiRequest) : Observable<TransaksiResponse>
}