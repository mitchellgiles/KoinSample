package com.example.mitchellgiles.koinsample

import android.app.Application
import android.arch.persistence.room.Room
import com.example.mitchellgiles.koinsample.data.AppDatabase
import com.example.mitchellgiles.koinsample.data.Repository
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    companion object {
        private lateinit var appDatabase: AppDatabase
        private lateinit var repository: Repository

        fun getRepository() = this.repository
    }


    override fun onCreate() {
        super.onCreate()

        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "Task").build()
        repository = Repository(appDatabase.taskDao())

//        startKoin(this, listOf(appModule))
    }


}