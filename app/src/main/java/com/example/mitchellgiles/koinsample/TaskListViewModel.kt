package com.example.mitchellgiles.koinsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.mitchellgiles.koinsample.data.Repository
import com.example.mitchellgiles.koinsample.data.Task
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class TaskListViewModel: ViewModel(), KoinComponent {
    val repository: Repository by inject()

    fun getTask(title: String): LiveData<Task> = repository.getTask(title)

    fun getTasks(): LiveData<List<Task>> = repository.getTasks()

    fun deleteTask(task: Task) = repository.deleteTask(task)

}