package com.example.mitchellgiles.koinsample.data

import android.arch.lifecycle.LiveData
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class Repository(val taskDao: TaskDao) {

    fun getTask(title: String): LiveData<Task> = taskDao.getTask(title)

    fun getTasks(): LiveData<List<Task>> = taskDao.getTasks()

    fun updateTask(title: String, detail: String, priority: String, originalTitle: String) {
        GlobalScope.launch { taskDao.updateTask(title, detail, priority, originalTitle) }
    }

    fun addTask(task: Task) = GlobalScope.launch { taskDao.addTask(task)  }

    fun deleteTask(task: Task) = GlobalScope.launch { taskDao.deleteTask(task) }

}