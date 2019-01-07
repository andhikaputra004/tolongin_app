package com.example.andhika.tolonginapp.section.detiltransaksi

import android.util.Log
import com.example.andhika.tolonginapp.base.BasePresenter
import com.example.andhika.tolonginapp.model.TransaksiRequest
import com.example.andhika.tolonginapp.network.NetworkManager
import javax.inject.Inject

class DetilTransaksiPresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter()
    , DetilTransaksiContract.Presenter {

    var view : DetilTransaksiContract.View? = null

    override fun doTransaksi(request: TransaksiRequest) {
        compositeDisposable.addAll(networkManager.doTransaksi(request,{
            Log.d("DHIKA", "MASUKBOSKU: ");
            when{
                it.success ?: true -> {
                    Log.d("DHIKA", "LEBIH MASUK: ");
                    view?.goToMain(it)
                }
            }
        },{

        }))
    }

    override fun takeView(view: DetilTransaksiContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }
}