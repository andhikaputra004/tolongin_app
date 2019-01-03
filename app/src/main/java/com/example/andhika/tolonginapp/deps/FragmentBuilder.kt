package com.example.andhika.tolonginapp.deps

import com.example.andhika.tolonginapp.section.historyfragment.HistoryFragment
import com.example.andhika.tolonginapp.section.homefragment.HomeFragment
import com.example.andhika.tolonginapp.section.profile.ProfileFragment
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

