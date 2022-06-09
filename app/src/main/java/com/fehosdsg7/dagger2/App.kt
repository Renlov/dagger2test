package com.fehosdsg7.dagger2

import android.app.Application
import android.content.Context
import com.fehosdsg7.dagger2.di.AppComponent
import com.fehosdsg7.dagger2.di.DaggerAppComponent

class App : Application() {
//    private var _appComponent : AppComponent? = null
//
//    internal val appComponent : AppComponent
//    get() = checkNotNull(_appComponent){
//        "AppComponent"
//    }


    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        //_appComponent = DaggerAppComponent.create()
       appComponent = DaggerAppComponent.create()

    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }