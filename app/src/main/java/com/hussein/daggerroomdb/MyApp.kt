package com.hussein.daggerroomdb

import android.app.Application
import com.hussein.daggerroomdb.di.AppComponent
import com.hussein.daggerroomdb.di.AppModule
import com.hussein.daggerroomdb.di.DaggerAppComponent

class MyApp:Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent= DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
    fun getAppComponent():AppComponent
    {
        return appComponent
    }
}