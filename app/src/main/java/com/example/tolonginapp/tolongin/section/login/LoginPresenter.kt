package com.example.tolonginapp.tolongin.section.login

import com.example.tolonginapp.tolongin.base.BasePresenter
import com.example.tolonginapp.tolongin.deps.ActivityScoped
import com.example.tolonginapp.tolongin.deps.SharedPreferenceHelper
import com.example.tolonginapp.tolongin.model.LoginRequest
import com.example.tolonginapp.tolongin.network.NetworkManager
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.EMAIL_PENGGUNA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_PENGGUNA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NAMA_PENGGUNA
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject


@ActivityScoped
class LoginPresenter @Inject constructor(val networkManager: NetworkManager,val sharedPreferenceHelper: SharedPreferenceHelper) : BasePresenter(),
    LoginContract.Presenter {


    private var view: LoginContract.View? = null

    override fun loginPresenter(request: LoginRequest) {
        compositeDisposable.add(networkManager.doLoginMobile(request, {
            when {
                it.success ?: true -> {
                    it.datapengguna?.let { data ->
                        sharedPreferenceHelper.setString(ID_PENGGUNA, data.idPengguna)
                        sharedPreferenceHelper.setString(NAMA_PENGGUNA, data.nama)
                        sharedPreferenceHelper.setString(EMAIL_PENGGUNA,data.email)
                    }
                    view?.goToMain(it)
                }
                it.success == false ->{
                    it.message?.let { it1 -> view?.showError(it1) }
                }
            }
        }, {
            view?.showError(it)
        }))
    }

    override fun setValidation(validation: Observable<Boolean>) {
        compositeDisposable.add(
            validation.observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view?.getValidation(it)
                }
        )
    }

    override fun takeView(view: LoginContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }

}