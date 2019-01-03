package com.example.andhika.tolonginapp

import android.content.Intent
import android.support.design.widget.BottomNavigationView
import com.example.andhika.tolonginapp.base.BaseActivity
import com.example.andhika.tolonginapp.deps.SharedPreferenceHelper
import com.example.andhika.tolonginapp.section.historyfragment.HistoryFragment
import com.example.andhika.tolonginapp.section.homefragment.HomeFragment
import com.example.andhika.tolonginapp.section.login.LoginActivity
import com.example.andhika.tolonginapp.section.profile.ProfileFragment
import com.example.andhika.tolonginapp.utils.Constant.CommonString.Companion.NAMA_PENGGUNA
import kotlinx.android.synthetic.main.activity_main2.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    private val defaultFragment = HomeFragment()
    private val profileFragment = ProfileFragment()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragment = when (item.itemId) {
            R.id.navigation_home -> {
                HomeFragment()
            }
            R.id.navigation_history -> {
                HistoryFragment()
            }
            else ->{
                ProfileFragment()
            }
        }

        supportFragmentManager.beginTransaction().replace(R.id.fl_content,fragment).commit()
        return@OnNavigationItemSelectedListener true
    }


    override fun onSetupLayout() {
        setContentView(R.layout.activity_main2)

    }

    override fun onViewReady() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction().replace(R.id.fl_content, defaultFragment).commit()
    }


}
