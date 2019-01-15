package com.example.tolonginapp.tolongin.section.detailTransaksi

import com.example.tolonginapp.tolongin.base.BasePresenter
import com.example.tolonginapp.tolongin.model.HistoryRequest
import com.example.tolonginapp.tolongin.network.NetworkManager
import javax.inject.Inject

class DetailTransPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter()
    , DetailTransContract.Presenter {
    var view: DetailTransContract.View? = null

    override fun takeView(view: DetailTransContract.View) {
        this.view = view
    }


    override fun getHistory(request: HistoryRequest) {
        compositeDisposable.addAll(networkManager.doGetHistory(request, {
            when {
                it.success ?: true -> {
                    view?.getHistoryList(it)
                }
            }
        }, {

        }))
    }


    override fun dropView() {
        view = null
    }

}