package com.example.tolonginapp.tolongin.section.transaksi

import com.example.tolonginapp.tolongin.base.BasePresenterInterface
import com.example.tolonginapp.tolongin.base.BaseViewInterface
import io.reactivex.Observable


interface TransaksiContract {
    interface View : BaseViewInterface<Presenter> {
        fun onValid(valid: Boolean)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun setValidation(validation: Observable<Boolean>)
    }
}