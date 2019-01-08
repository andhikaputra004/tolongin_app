package com.example.tolonginapp.tolongin.section.register

import android.content.Intent
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.base.BaseActivity
import com.example.tolonginapp.tolongin.model.RegisterRequest
import com.example.tolonginapp.tolongin.model.RegisterResponse
import com.example.tolonginapp.tolongin.section.login.LoginActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : BaseActivity() , RegisterContract.View{

    @Inject
    lateinit var presenter: RegisterPresenter

    override fun onSetupLayout() {
        setContentView(R.layout.activity_register)
//        setupToolbarTitle(toolbar as Toolbar, R.string.txt_detail_transaksi,R.drawable.ic_arrow_back_white_24dp)

    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)

        presenter.setValidation(
            Observable.combineLatest(
                RxTextView.textChanges(et_nama).map {
                    it.isNotEmpty()
                },
                RxTextView.textChanges(et_telp).map {
                    it.isNotEmpty() && it.length > 11
                },
                BiFunction { nama, telp ->
                    nama && telp
                }
            )
        )
        btn_register.setOnClickListener {
            presenter.registerPresenter(RegisterRequest(et_nama.text.toString(),et_telp.text.toString()))
        }
    }

    override fun goToMain(registerResponse: RegisterResponse) {
        startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
    }

    override fun getValidation(boolean: Boolean) {
        with(btn_register){
            this.isEnabled = boolean
            when{
                boolean ->{
                    this.setBackgroundResource(R.drawable.rounded_button)
                }
                else ->{
                    this.setBackgroundResource(R.drawable.rounded_button_disable)
                }
            }
        }
    }
}