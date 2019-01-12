package com.example.tolonginapp.tolongin.section.register

import com.example.tolonginapp.tolongin.base.BasePresenterInterface
import com.example.tolonginapp.tolongin.base.BaseViewInterface
import com.example.tolonginapp.tolongin.model.RegisterRequest
import com.example.tolonginapp.tolongin.model.RegisterResponse
import io.reactivex.Observable

interface RegisterContract {
    interface View : BaseViewInterface<Presenter> {
        fun goToMain(registerResponse: RegisterResponse)
        fun getValidation(boolean: Boolean)
        fun showError(error : Any)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun registerPresenter(request: RegisterRequest)
        fun setValidation(validation: Observable<Boolean>)
    }
}