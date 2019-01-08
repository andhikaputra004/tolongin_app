package com.example.tolonginapp.tolongin.deps

import android.annotation.SuppressLint
import com.example.tolonginapp.tolongin.MainActivity
import com.example.tolonginapp.tolongin.section.detailbencana.DetailBencanaActivity
import com.example.tolonginapp.tolongin.section.detiltransaksi.DetilTransaksiActivity
import com.example.tolonginapp.tolongin.section.gantipassword.ChangePasswordActivity
import com.example.tolonginapp.tolongin.section.login.LoginActivity
import com.example.tolonginapp.tolongin.section.register.RegisterActivity
import com.example.tolonginapp.tolongin.section.transaksi.TransaksiActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@SuppressLint("unused")
@Module
abstract class ActivityBuilder {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindRegisterActivity(): RegisterActivity


    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindDetilBencanaActivity(): DetailBencanaActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindTransaksiActivity(): TransaksiActivity


    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindDetilTransaksiActivity(): DetilTransaksiActivity


    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindChangePasswordActivity(): ChangePasswordActivity
}