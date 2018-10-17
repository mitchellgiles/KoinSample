package com.example.mitchellgiles.koinsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.mitchellgiles.koinsample.data.Task

class AddTaskViewModel: ViewModel() {


    val repository = MainApplication.getRepository()

    fun addTask(task: Task) = repository.addTask(task)

    fun getTask(title: String): LiveData<Task> = repository.getTask(title)

    fun updateTask(task: Task, originalTitle: String) {
        repository.updateTask(task.title, task.details, task.priority, originalTitle)
    }

}