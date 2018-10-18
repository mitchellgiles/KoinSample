package com.example.mitchellgiles.koinsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.mitchellgiles.koinsample.data.Repository
import com.example.mitchellgiles.koinsample.data.Task
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class AddTaskViewModel: ViewModel(), KoinComponent {

    val repository: Repository by inject()

    fun addTask(task: Task) = repository.addTask(task)

    fun getTask(title: String): LiveData<Task> = repository.getTask(title)

    fun updateTask(task: Task, originalTitle: String) {
        repository.updateTask(task.title, task.details, task.priority, originalTitle)
    }

}