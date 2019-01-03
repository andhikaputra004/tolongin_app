package com.example.andhika.tolonginapp.section.gantipassword

import android.content.Intent
import android.util.Log
import com.example.andhika.tolonginapp.R
import com.example.andhika.tolonginapp.base.BaseActivity
import com.example.andhika.tolonginapp.deps.SharedPreferenceHelper
import com.example.andhika.tolonginapp.model.ChangePasswordRequest
import com.example.andhika.tolonginapp.model.ChangePasswordResponse
import com.example.andhika.tolonginapp.section.login.LoginActivity
import com.example.andhika.tolonginapp.utils.Constant.CommonString.Companion.ID_PENGGUNA
import kotlinx.android.synthetic.main.activity_change_password.*
import javax.inject.Inject

class ChangePasswordActivity : BaseActivity() , ChangePasswordContract.View{


    @Inject
    lateinit var presenter: ChangePasswordPresenter

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    override fun onSetupLayout() {
        setContentView(R.layout.activity_change_password)
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)

        btn_change_password.setOnClickListener {
            presenter.changePassword(ChangePasswordRequest(sharedPreferenceHelper.getString(ID_PENGGUNA).toInt()
                ,et_new_password.text.toString()))

        }
    }
    override fun changePasswordResponse(response: ChangePasswordResponse) {
        finish()
        startActivity(Intent(this,LoginActivity::class.java))
    }
}