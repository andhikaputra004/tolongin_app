package com.example.andhika.tolonginapp.section.login

import com.example.andhika.tolonginapp.base.BasePresenterInterface
import com.example.andhika.tolonginapp.base.BaseViewInterface
import com.example.andhika.tolonginapp.model.LoginRequest
import com.example.andhika.tolonginapp.model.LoginResponse
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