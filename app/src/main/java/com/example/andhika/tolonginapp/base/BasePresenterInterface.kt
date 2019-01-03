package com.example.andhika.tolonginapp.base


interface BasePresenterInterface<T> {
    fun takeView(view: T)
    fun dropView()
}