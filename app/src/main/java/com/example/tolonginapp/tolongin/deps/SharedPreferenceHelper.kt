package com.example.tolonginapp.tolongin.deps

import android.content.SharedPreferences
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_PENGGUNA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NAMA_PENGGUNA

class SharedPreferenceHelper(val sharedPreference: SharedPreferences){
    fun setBoolean(key: String, value: Boolean) {
        sharedPreference.edit().putBoolean(key, value).apply()
    }

    fun setString(key: String, value: String) {
        sharedPreference.edit().putString(key, value).apply()
    }

    fun setInt(key: String, value: Int) {
        sharedPreference.edit().putInt(key, value).apply()
    }

    fun setLong(key: String, value: Long) {
        sharedPreference.edit().putLong(key, value).apply()
    }

    fun getBoolean(key: String) = sharedPreference.getBoolean(key, false)

    fun getString(key: String) = sharedPreference.getString(key, "")

    fun getInt(key: String) = sharedPreference.getInt(key, 0)

    fun getLong(key: String) = sharedPreference.getLong(key, 0)

    fun removeSession() {
        setString(ID_PENGGUNA, "")
        setString(NAMA_PENGGUNA, "")
    }

}