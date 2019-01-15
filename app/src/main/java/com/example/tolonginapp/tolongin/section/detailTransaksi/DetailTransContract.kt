package com.example.tolonginapp.tolongin.section.detailTransaksi

import com.example.tolonginapp.tolongin.base.BasePresenterInterface
import com.example.tolonginapp.tolongin.base.BaseViewInterface
import com.example.tolonginapp.tolongin.model.HistoryRequest
import com.example.tolonginapp.tolongin.model.HistoryResponse


interface DetailTransContract {
    interface View : BaseViewInterface<Presenter> {
        fun getHistoryList(historyResponse: HistoryResponse)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun getHistory(request: HistoryRequest)
    }
}