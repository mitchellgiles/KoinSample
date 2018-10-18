package com.example.mitchellgiles.koinsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.mitchellgiles.koinsample.data.Repository
import com.example.mitchellgiles.koinsample.data.Task
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class TaskListViewModel(private val repo: Repository): ViewModel() {

    fun getTask(title: String): LiveData<Task> = repo.getTask(title)

    fun getTasks(): LiveData<List<Task>> = repo.getTasks()

    fun deleteTask(task: Task) = repo.deleteTask(task)

}