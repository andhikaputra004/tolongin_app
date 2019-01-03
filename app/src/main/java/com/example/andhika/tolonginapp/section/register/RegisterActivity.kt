package com.example.andhika.tolonginapp.section.register

import android.content.Intent
import com.example.andhika.tolonginapp.R
import com.example.andhika.tolonginapp.base.BaseActivity
import com.example.andhika.tolonginapp.model.RegisterRequest
import com.example.andhika.tolonginapp.model.RegisterResponse
import com.example.andhika.tolonginapp.section.login.LoginActivity
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