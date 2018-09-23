package com.example.edblack.shopifyandroidmobileintern

import android.app.Application
import com.example.edblack.shopifyandroidmobileintern.di.AppComponent
import com.example.edblack.shopifyandroidmobileintern.di.DaggerAppComponent


class App : Application() {

    companion object {
        lateinit var instance: App
            private set

        val component: AppComponent by lazy { DaggerAppComponent.builder().build() }
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        component.inject(this)
    }
}