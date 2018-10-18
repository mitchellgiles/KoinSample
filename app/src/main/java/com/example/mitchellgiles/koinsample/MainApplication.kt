package com.example.mitchellgiles.koinsample

import android.app.Application
import android.arch.persistence.room.Room
import com.example.mitchellgiles.koinsample.data.AppDatabase
import com.example.mitchellgiles.koinsample.data.Repository
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }


}