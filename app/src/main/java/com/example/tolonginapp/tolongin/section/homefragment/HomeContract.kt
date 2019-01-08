package com.example.tolonginapp.tolongin.section.homefragment

import com.example.tolonginapp.tolongin.base.BasePresenterInterface
import com.example.tolonginapp.tolongin.base.BaseViewInterface
import com.example.tolonginapp.tolongin.model.ListBencanaResponse


interface HomeContract {
    interface View : BaseViewInterface<Presenter> {
        fun getList(response : ListBencanaResponse)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun getBencana()
    }
}