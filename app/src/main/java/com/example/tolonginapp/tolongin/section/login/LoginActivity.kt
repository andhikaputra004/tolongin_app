package com.example.tolonginapp.tolongin.section.login

import android.content.Intent
import android.graphics.Color
import android.support.v4.content.res.ResourcesCompat
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import com.example.tolonginapp.tolongin.MainActivity
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.base.BaseActivity
import com.example.tolonginapp.tolongin.ext.getColorCompat
import com.example.tolonginapp.tolongin.model.LoginRequest
import com.example.tolonginapp.tolongin.model.LoginResponse
import com.example.tolonginapp.tolongin.section.register.RegisterActivity
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
        setClickRegister()

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
        finishAffinity()
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

    private fun setClickRegister(){
        val str2 = getString(R.string.txt_sign_up)
        val str = getString(R.string.txt_don_t_have_an_account_sign_up,str2)
        val start = str.indexOf(str2)
        val end = start + str2.length

        val spanBuilder = SpannableStringBuilder(str)
        val clickSpan = object : ClickableSpan() {
            override fun onClick(widget: View?) {
            }

            override fun updateDrawState(ds: TextPaint?) {
                super.updateDrawState(ds)
                ds?.let {
                    it.isUnderlineText = false
                    it.color = this@LoginActivity.getColorCompat(R.color.colorPrimary)
                    it.typeface = ResourcesCompat.getFont(this@LoginActivity, R.font.roboto_bold)
                }
            }

        }
        spanBuilder.setSpan(clickSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        with(tv_sign_up){
            text = spanBuilder
            highlightColor = Color.TRANSPARENT
            movementMethod = LinkMovementMethod.getInstance()
            setOnClickListener {
                startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
            }

        }

    }
}
