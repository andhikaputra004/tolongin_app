package com.example.tolonginapp.tolongin.section.login

import com.example.tolonginapp.tolongin.base.BasePresenterInterface
import com.example.tolonginapp.tolongin.base.BaseViewInterface
import com.example.tolonginapp.tolongin.model.LoginRequest
import com.example.tolonginapp.tolongin.model.LoginResponse
import io.reactivex.Observable


interface LoginContract {
    interface View : BaseViewInterface<Presenter> {
        fun goToMain(loginResponse: LoginResponse)
        fun getValidation(boolean: Boolean)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun loginPresenter(request: LoginRequest)
        fun setValidation(validation : Observable<Boolean>)
    }
}