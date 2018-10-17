package com.example.mitchellgiles.koinsample.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Room
import android.content.Context


@Database(entities = arrayOf(Task::class), version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao

}