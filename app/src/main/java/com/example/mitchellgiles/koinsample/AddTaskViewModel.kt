package com.example.mitchellgiles.koinsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.mitchellgiles.koinsample.data.Repository
import com.example.mitchellgiles.koinsample.data.Task
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import kotlin.coroutines.experimental.CoroutineContext

class AddTaskViewModel: ViewModel(), KoinComponent, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private val repository: Repository by inject()

    fun addTask(task: Task) = launch { repository.addTask(task) }

    fun getTask(title: String): LiveData<Task> = repository.getTask(title)

    fun updateTask(task: Task, originalTitle: String) {
        launch { repository.updateTask(task.title, task.details, task.priority, originalTitle) }
    }

    override fun onCleared() {
        job.cancel()
    }
}