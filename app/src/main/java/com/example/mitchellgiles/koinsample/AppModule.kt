package com.example.mitchellgiles.koinsample

import android.arch.persistence.room.Room
import com.example.mitchellgiles.koinsample.data.AppDatabase
import com.example.mitchellgiles.koinsample.data.Repository
import com.example.mitchellgiles.koinsample.data.TaskDao
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    single { androidApplication() as MainApplication }
    single { Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "Task").build() }
    single { Repository(get<AppDatabase>().taskDao())}
    viewModel<AddTaskViewModel> { AddTaskViewModel() }
    viewModel<TaskListViewModel> { TaskListViewModel() }
}