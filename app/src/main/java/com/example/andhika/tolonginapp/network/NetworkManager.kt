package com.example.andhika.tolonginapp.network

import com.example.andhika.tolonginapp.ext.uisubscribe
import com.example.andhika.tolonginapp.model.*

class NetworkManager(val networkService: NetworkService){

    fun doLoginMobile(request: LoginRequest,
                      onNext: (LoginResponse) -> Unit,
                      onError: (Throwable) -> Unit) = networkService
        .loginMoble(request)
        .uisubscribe(onNext, onError)


    fun doRegisterMobile(request: RegisterRequest,
                      onNext: (RegisterResponse) -> Unit,
                      onError: (Throwable) -> Unit) = networkService
        .registerMobile(request)
        .uisubscribe(onNext, onError)

    fun doGetListBencana(
        onNext: (ListBencanaResponse) -> Unit,
        onError: (Throwable) -> Unit) = networkService
        .listBencana()
        .uisubscribe(onNext, onError)


    fun doChangePassword(request: ChangePasswordRequest,
        onNext: (ChangePasswordResponse) -> Unit,
        onError: (Throwable) -> Unit) = networkService
        .changePassword(request)
        .uisubscribe(onNext, onError)


    fun doGetHistory(request: HistoryRequest,
                         onNext: (HistoryResponse) -> Unit,
                         onError: (Throwable) -> Unit) = networkService
        .getHistory(request)
        .uisubscribe(onNext, onError)


    fun doTransaksi(request: TransaksiRequest,
                     onNext: (TransaksiResponse) -> Unit,
                     onError: (Throwable) -> Unit) = networkService
        .doTransaksi(request)
        .uisubscribe(onNext, onError)
}