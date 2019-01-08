package com.example.tolonginapp.tolongin.section.historyfragment

import com.example.tolonginapp.tolongin.base.BasePresenter
import com.example.tolonginapp.tolongin.model.HistoryRequest
import com.example.tolonginapp.tolongin.network.NetworkManager
import javax.inject.Inject

class HistoryPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter() , HistoryContract.Presenter {
    var view : HistoryContract.View? = null

    override fun getHistory(request: HistoryRequest) {
        compositeDisposable.addAll(networkManager.doGetHistory(request,{
            when{
                it.success ?: true ->{
                    view?.getHistoryList(it)
                }
            }
        },{

        }))
    }

    override fun takeView(view: HistoryContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }
}