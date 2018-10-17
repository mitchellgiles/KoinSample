package com.example.mitchellgiles.koinsample.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task")
    fun getTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE title = :title")
    fun getTask(title: String): LiveData<Task>

    @Query("UPDATE Task SET title = :title, details = :detail, priority = :priority WHERE title = :originalTitle")
    fun updateTask(title: String, detail: String, priority: String, originalTitle: String)

    @Insert
    fun addTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}