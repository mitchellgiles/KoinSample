package com.example.mitchellgiles.koinsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.mitchellgiles.koinsample.data.Task

class TaskListViewModel: ViewModel() {
    val repository = MainApplication.getRepository()

    fun getTask(title: String): LiveData<Task> = repository.getTask(title)

    fun getTasks(): LiveData<List<Task>> = repository.getTasks()

    fun deleteTask(task: Task) = repository.deleteTask(task)

}