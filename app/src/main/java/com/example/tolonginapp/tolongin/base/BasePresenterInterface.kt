package com.example.tolonginapp.tolongin.base


interface BasePresenterInterface<T> {
    fun takeView(view: T)
    fun dropView()
}