package com.example.andhika.tolonginapp.section.homefragment

import com.example.andhika.tolonginapp.base.BasePresenter
import com.example.andhika.tolonginapp.deps.FragmentScoped
import com.example.andhika.tolonginapp.network.NetworkManager
import javax.inject.Inject

@FragmentScoped
class HomePresenter @Inject constructor(val networkManager: NetworkManager) : BasePresenter() , HomeContract.Presenter{

    var view : HomeContract.View? = null

    override fun getBencana() {
        compositeDisposable.addAll(networkManager.doGetListBencana({
            when{
                it.success ?: true ->{
                    view?.getList(it)
                }
            }
        },{

        }))
    }

    override fun takeView(view: HomeContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }

}