package com.example.mitchellgiles.koinsample.di

import android.arch.persistence.room.Room
import com.example.mitchellgiles.koinsample.AddTaskViewModel
import com.example.mitchellgiles.koinsample.TaskListViewModel
import com.example.mitchellgiles.koinsample.data.AppDatabase
import com.example.mitchellgiles.koinsample.data.Repository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    single { androidApplication() as MainApplication }
    single { Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "Task").build() }
    single { Repository(get<AppDatabase>().taskDao())}
    viewModel{ AddTaskViewModel() }
    viewModel{ TaskListViewModel(get()) }
}