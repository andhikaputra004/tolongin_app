package com.example.andhika.tolonginapp.section.homefragment

import com.example.andhika.tolonginapp.base.BasePresenterInterface
import com.example.andhika.tolonginapp.base.BaseViewInterface
import com.example.andhika.tolonginapp.model.ListBencanaResponse


interface HomeContract {
    interface View : BaseViewInterface<Presenter> {
        fun getList(response : ListBencanaResponse)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun getBencana()
    }
}