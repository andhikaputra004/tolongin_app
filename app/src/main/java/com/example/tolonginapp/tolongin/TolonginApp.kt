package com.example.tolonginapp.tolongin

import com.example.tolonginapp.tolongin.deps.DaggerAppComponent
import com.example.tolonginapp.tolongin.deps.NetworkModule
import com.example.tolonginapp.tolongin.deps.SharedPreferenceModule
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.SHARED_PREFERENCE_NAME
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TolonginApp : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        val appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .sharedPreference(SharedPreferenceModule(SHARED_PREFERENCE_NAME,this))
            .networkModule(NetworkModule())
            .build()
        appComponent.inject(this)
        return appComponent
    }

}