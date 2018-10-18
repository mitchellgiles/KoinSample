package com.example.mitchellgiles.koinsample.di

import android.app.Application
import com.example.mitchellgiles.koinsample.di.appModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }


}