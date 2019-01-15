package com.example.tolonginapp.tolongin.section.detailTransaksi

import com.example.tolonginapp.tolongin.base.BasePresenter
import com.example.tolonginapp.tolongin.model.UpdateTransRequest
import com.example.tolonginapp.tolongin.network.NetworkManager
import javax.inject.Inject

class DetailTransPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter()
    , DetailTransContract.Presenter {
    var view: DetailTransContract.View? = null

    override fun updateTransReq(request: UpdateTransRequest) {
        compositeDisposable.addAll(networkManager.doUpdateTransaksi(request,{
            when{
                it.status ?: true ->{
                    view?.updateTrans(it)
                }
            }
        },{

        }))
    }

    override fun takeView(view: DetailTransContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }


}