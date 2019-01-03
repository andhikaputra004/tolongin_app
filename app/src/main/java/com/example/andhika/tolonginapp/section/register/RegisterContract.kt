package com.example.andhika.tolonginapp.section.register

import com.example.andhika.tolonginapp.base.BasePresenterInterface
import com.example.andhika.tolonginapp.base.BaseViewInterface
import com.example.andhika.tolonginapp.model.RegisterRequest
import com.example.andhika.tolonginapp.model.RegisterResponse
import io.reactivex.Observable

interface RegisterContract {
    interface View : BaseViewInterface<Presenter> {
        fun goToMain(registerResponse: RegisterResponse)
        fun getValidation(boolean: Boolean)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun registerPresenter(request: RegisterRequest)
        fun setValidation(validation: Observable<Boolean>)
    }
}