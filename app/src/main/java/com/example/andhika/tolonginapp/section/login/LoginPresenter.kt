package com.example.andhika.tolonginapp.section.login

import android.util.Log
import com.example.andhika.tolonginapp.base.BasePresenter
import com.example.andhika.tolonginapp.deps.ActivityScoped
import com.example.andhika.tolonginapp.deps.SharedPreferenceHelper
import com.example.andhika.tolonginapp.model.LoginRequest
import com.example.andhika.tolonginapp.network.NetworkManager
import com.example.andhika.tolonginapp.utils.Constant.CommonString.Companion.ID_PENGGUNA
import com.example.andhika.tolonginapp.utils.Constant.CommonString.Companion.NAMA_PENGGUNA
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
                    }
                    view?.goToMain(it)
                }
            }
        }, {

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