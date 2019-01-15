package com.example.tolonginapp.tolongin.section.detailTransaksi

import com.example.tolonginapp.tolongin.base.BasePresenterInterface
import com.example.tolonginapp.tolongin.base.BaseViewInterface
import com.example.tolonginapp.tolongin.model.UpdateTransRequest
import com.example.tolonginapp.tolongin.model.UpdateTransResponse


interface DetailTransContract {
    interface View : BaseViewInterface<Presenter> {
        fun updateTrans(response: UpdateTransResponse)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun updateTransReq(request: UpdateTransRequest)
    }
}