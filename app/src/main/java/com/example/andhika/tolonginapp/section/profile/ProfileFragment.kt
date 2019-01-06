package com.example.andhika.tolonginapp.section.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.andhika.tolonginapp.R
import com.example.andhika.tolonginapp.deps.SharedPreferenceHelper
import com.example.andhika.tolonginapp.section.gantipassword.ChangePasswordActivity
import com.example.andhika.tolonginapp.section.login.LoginActivity
import com.example.andhika.tolonginapp.utils.Constant.CommonString.Companion.NAMA_PENGGUNA
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

class ProfileFragment : DaggerFragment() {

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_name.text = sharedPreferenceHelper.getString(NAMA_PENGGUNA)
        btn_logout.setOnClickListener {
//            sharedPreferenceHelper.removeSession()
            startActivity(Intent(activity,ChangePasswordActivity::class.java))
        }
    }
}