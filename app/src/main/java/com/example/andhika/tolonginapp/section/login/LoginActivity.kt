package com.example.andhika.tolonginapp.section.login

import android.content.Intent
import com.example.andhika.tolonginapp.MainActivity
import com.example.andhika.tolonginapp.R
import com.example.andhika.tolonginapp.base.BaseActivity
import com.example.andhika.tolonginapp.model.LoginRequest
import com.example.andhika.tolonginapp.model.LoginResponse
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {
    @Inject
    lateinit var presenter: LoginPresenter


    override fun onSetupLayout() {
        setContentView(R.layout.activity_login)
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)

        btn_login.setOnClickListener {
            presenter.loginPresenter(LoginRequest(et_email.text.toString(), et_password.text.toString()))
        }

        presenter.setValidation(
            Observable.combineLatest(
                RxTextView.textChanges(et_email).map {
                    it.isNotEmpty()
                },
                RxTextView.textChanges(et_password).map {
                    it.isNotEmpty()
                },
                BiFunction { email, pass ->
                    email && pass
                }
            ))
    }

    override fun goToMain(loginResponse: LoginResponse) {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    override fun getValidation(boolean: Boolean) {
        with(btn_login) {
            isEnabled = boolean
            when {
                boolean -> {
                    btn_login.setBackgroundResource(R.drawable.rounded_button)
                }
                else -> {
                    btn_login.setBackgroundResource(R.drawable.rounded_button_disable)
                }
            }
        }
    }
}
