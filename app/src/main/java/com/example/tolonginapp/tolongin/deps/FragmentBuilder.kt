package com.example.tolonginapp.tolongin.deps

import com.example.tolonginapp.tolongin.section.historyfragment.HistoryFragment
import com.example.tolonginapp.tolongin.section.homefragment.HomeFragment
import com.example.tolonginapp.tolongin.section.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment


    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindProfileFragment(): ProfileFragment


    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindHistoryFragment(): HistoryFragment
}

