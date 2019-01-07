package com.example.andhika.tolonginapp.section.detiltransaksi

import com.example.andhika.tolonginapp.base.BasePresenterInterface
import com.example.andhika.tolonginapp.base.BaseViewInterface
import com.example.andhika.tolonginapp.model.TransaksiRequest
import com.example.andhika.tolonginapp.model.TransaksiResponse

interface DetilTransaksiContract {
    interface View : BaseViewInterface<Presenter> {
        fun goToMain(response: TransaksiResponse)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun doTransaksi(request: TransaksiRequest)
    }
}