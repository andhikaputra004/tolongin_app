package com.example.andhika.tolonginapp

import com.example.andhika.tolonginapp.deps.DaggerAppComponent
import com.example.andhika.tolonginapp.deps.NetworkModule
import com.example.andhika.tolonginapp.deps.SharedPreferenceModule
import com.example.andhika.tolonginapp.utils.Constant.CommonString.Companion.SHARED_PREFERENCE_NAME
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