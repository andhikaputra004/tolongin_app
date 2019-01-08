package com.example.tolonginapp.tolongin.section.gantipassword

import android.content.Intent
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.base.BaseActivity
import com.example.tolonginapp.tolongin.deps.SharedPreferenceHelper
import com.example.tolonginapp.tolongin.model.ChangePasswordRequest
import com.example.tolonginapp.tolongin.model.ChangePasswordResponse
import com.example.tolonginapp.tolongin.section.login.LoginActivity
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_PENGGUNA
import kotlinx.android.synthetic.main.activity_change_password.*
import javax.inject.Inject

class ChangePasswordActivity : BaseActivity() , ChangePasswordContract.View{


    @Inject
    lateinit var presenter: ChangePasswordPresenter

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    override fun onSetupLayout() {
        setContentView(R.layout.activity_change_password)
//        setupToolbarTitle(toolbar as Toolbar, R.string.txt_detail_transaksi,R.drawable.ic_arrow_back_white_24dp)
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