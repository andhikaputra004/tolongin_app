package com.example.tolonginapp.tolongin.section.detiltransaksi

import com.example.tolonginapp.tolongin.base.BasePresenterInterface
import com.example.tolonginapp.tolongin.base.BaseViewInterface
import com.example.tolonginapp.tolongin.model.TransaksiRequest
import com.example.tolonginapp.tolongin.model.TransaksiResponse

interface DetilTransaksiContract {
    interface View : BaseViewInterface<Presenter> {
        fun goToMain(response: TransaksiResponse)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun doTransaksi(request: TransaksiRequest)
    }
}