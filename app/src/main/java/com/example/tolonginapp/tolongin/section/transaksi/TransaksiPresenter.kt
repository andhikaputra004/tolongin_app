package com.example.tolonginapp.tolongin.section.transaksi

import com.example.tolonginapp.tolongin.base.BasePresenter
import com.example.tolonginapp.tolongin.deps.ActivityScoped
import io.reactivex.Observable
import javax.inject.Inject

@ActivityScoped
class TransaksiPresenter @Inject constructor() : BasePresenter(), TransaksiContract.Presenter {

    var view: TransaksiContract.View? = null

    override fun setValidation(validation: Observable<Boolean>) {
        compositeDisposable.add(
            validation.subscribe {
                view?.onValid(it)
            }
        )
    }

    override fun takeView(view: TransaksiContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }

}