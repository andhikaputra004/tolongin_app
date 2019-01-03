package com.example.andhika.tolonginapp.deps

import android.annotation.SuppressLint
import com.example.andhika.tolonginapp.MainActivity
import com.example.andhika.tolonginapp.section.detailbencana.DetailBencanaActivity
import com.example.andhika.tolonginapp.section.detiltransaksi.DetilTransaksiActivity
import com.example.andhika.tolonginapp.section.gantipassword.ChangePasswordActivity
import com.example.andhika.tolonginapp.section.login.LoginActivity
import com.example.andhika.tolonginapp.section.register.RegisterActivity
import com.example.andhika.tolonginapp.section.transaksi.TransaksiActivity
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