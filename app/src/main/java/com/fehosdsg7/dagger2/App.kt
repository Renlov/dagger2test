package com.fehosdsg7.dagger2

import android.app.Application
import android.content.Context
import com.fehosdsg7.dagger2.di.*

class App : Application() {
    lateinit var appComponent: AppComponent
        private set

    lateinit var firstAndSecondComponent: FirstAndSecondComponent
        private set

    lateinit var thirdComponent: ThirdComponent
        private set

    override fun onCreate() {
        super.onCreate()
       appComponent = DaggerAppComponent.create()
        firstAndSecondComponent = DaggerFirstAndSecondComponent.create()
        thirdComponent = DaggerThirdComponent.create()

    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }

val Context.firstAndSecondComponent: FirstAndSecondComponent
    get() = when (this) {
        is App -> firstAndSecondComponent
        else -> applicationContext.firstAndSecondComponent
    }

val Context.thirdComponent: ThirdComponent
    get() = when (this) {
        is App -> thirdComponent
        else -> applicationContext.thirdComponent
    }