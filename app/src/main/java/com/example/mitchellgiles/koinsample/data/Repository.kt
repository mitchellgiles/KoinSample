package com.example.mitchellgiles.koinsample.data

import android.arch.lifecycle.LiveData
import kotlinx.coroutines.experimental.*

class Repository(val taskDao: TaskDao) {

    fun getTask(title: String): LiveData<Task> = taskDao.getTask(title)

    fun getTasks(): LiveData<List<Task>> = taskDao.getTasks()

    suspend fun updateTask(title: String, detail: String, priority: String, originalTitle: String) {
        withContext(Dispatchers.IO) { taskDao.updateTask(title, detail, priority, originalTitle) }
    }

    suspend fun addTask(task: Task) = withContext(Dispatchers.IO) { taskDao.addTask(task)  }

    suspend fun deleteTask(task: Task) = withContext(Dispatchers.IO) { taskDao.deleteTask(task) }

}