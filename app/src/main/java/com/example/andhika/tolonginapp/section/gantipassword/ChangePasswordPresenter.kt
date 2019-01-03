package com.example.andhika.tolonginapp.section.gantipassword

import com.example.andhika.tolonginapp.base.BasePresenter
import com.example.andhika.tolonginapp.model.ChangePasswordRequest
import com.example.andhika.tolonginapp.network.NetworkManager
import javax.inject.Inject

class ChangePasswordPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter() , ChangePasswordContract.Presenter{
    private var view : ChangePasswordContract.View? = null

    override fun changePassword(request: ChangePasswordRequest) {
        compositeDisposable.addAll(networkManager.doChangePassword(request,{
            view?.changePasswordResponse(it)
        },{

        }))
    }

    override fun takeView(view: ChangePasswordContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }

}