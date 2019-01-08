package com.example.tolonginapp.tolongin

import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.Toolbar
import com.example.tolonginapp.tolongin.base.BaseActivity
import com.example.tolonginapp.tolongin.deps.SharedPreferenceHelper
import com.example.tolonginapp.tolongin.section.historyfragment.HistoryFragment
import com.example.tolonginapp.tolongin.section.homefragment.HomeFragment
import com.example.tolonginapp.tolongin.section.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main2.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    private val defaultFragment = HomeFragment()
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
        setupToolbarTitleNoBack(toolbar as Toolbar,R.string.txt_donasi)
    }

    override fun onViewReady() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction().replace(R.id.fl_content, defaultFragment).commit()
    }


}
