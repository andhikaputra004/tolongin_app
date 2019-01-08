package com.example.tolonginapp.tolongin.section.gantipassword

import com.example.tolonginapp.tolongin.base.BasePresenterInterface
import com.example.tolonginapp.tolongin.base.BaseViewInterface
import com.example.tolonginapp.tolongin.model.ChangePasswordRequest
import com.example.tolonginapp.tolongin.model.ChangePasswordResponse

interface ChangePasswordContract{
    interface View : BaseViewInterface<Presenter> {
        fun changePasswordResponse(response : ChangePasswordResponse)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun changePassword(request: ChangePasswordRequest)
    }
}