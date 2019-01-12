package com.example.tolonginapp.tolongin.section.register

import com.example.tolonginapp.tolongin.base.BasePresenter
import com.example.tolonginapp.tolongin.deps.ActivityScoped
import com.example.tolonginapp.tolongin.model.RegisterRequest
import com.example.tolonginapp.tolongin.network.NetworkManager
import io.reactivex.Observable
import javax.inject.Inject

@ActivityScoped
class RegisterPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter(),
    RegisterContract.Presenter {
    var view: RegisterContract.View? = null
    override fun registerPresenter(request: RegisterRequest) {
        compositeDisposable.add(networkManager.doRegisterMobile(request, {
            when {
                it.success == true -> {
                    view?.goToMain(it)
                }
                it.success == false ->{
                    it.message?.let { it1 -> view?.showError(it1) }
                }
            }
        }, {
            it.message?.let { it1 -> view?.showError(it1) }
        }))
    }

    override fun setValidation(validation: Observable<Boolean>) {
        compositeDisposable.add(
            validation.subscribe {
                view?.getValidation(it)
            }
        )
    }

    override fun takeView(view: RegisterContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }
}