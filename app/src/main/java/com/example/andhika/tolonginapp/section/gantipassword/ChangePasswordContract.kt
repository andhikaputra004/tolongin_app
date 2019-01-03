package com.example.andhika.tolonginapp.section.gantipassword

import com.example.andhika.tolonginapp.base.BasePresenterInterface
import com.example.andhika.tolonginapp.base.BaseViewInterface
import com.example.andhika.tolonginapp.model.ChangePasswordRequest
import com.example.andhika.tolonginapp.model.ChangePasswordResponse
import com.example.andhika.tolonginapp.model.ListBencanaResponse

interface ChangePasswordContract{
    interface View : BaseViewInterface<Presenter> {
        fun changePasswordResponse(response : ChangePasswordResponse)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun changePassword(request: ChangePasswordRequest)
    }
}