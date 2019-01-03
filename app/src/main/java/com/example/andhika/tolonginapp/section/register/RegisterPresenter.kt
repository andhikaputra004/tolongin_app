package com.example.andhika.tolonginapp.section.register

import com.example.andhika.tolonginapp.base.BasePresenter
import com.example.andhika.tolonginapp.deps.ActivityScoped
import com.example.andhika.tolonginapp.model.RegisterRequest
import com.example.andhika.tolonginapp.network.NetworkManager
import io.reactivex.Observable
import javax.inject.Inject

@ActivityScoped
class RegisterPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter(),
    RegisterContract.Presenter {
    var view: RegisterContract.View? = null
    override fun registerPresenter(request: RegisterRequest) {
        compositeDisposable.add(networkManager.doRegisterMobile(request, {
            when {
                it.success ?: false -> {
                    view?.goToMain(it)
                }
            }
        }, {

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