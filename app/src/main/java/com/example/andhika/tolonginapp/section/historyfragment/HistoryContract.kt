package com.example.andhika.tolonginapp.section.historyfragment

import com.example.andhika.tolonginapp.base.BasePresenterInterface
import com.example.andhika.tolonginapp.base.BaseViewInterface
import com.example.andhika.tolonginapp.model.HistoryRequest
import com.example.andhika.tolonginapp.model.HistoryResponse


interface HistoryContract {
    interface View : BaseViewInterface<Presenter> {
        fun getHistoryList(historyResponse: HistoryResponse)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun getHistory(request: HistoryRequest)
    }
}