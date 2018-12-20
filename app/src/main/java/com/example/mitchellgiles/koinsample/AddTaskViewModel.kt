package com.example.mitchellgiles.koinsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.mitchellgiles.koinsample.data.Repository
import com.example.mitchellgiles.koinsample.data.Task
import io.reactivex.Single
import kotlinx.coroutines.*
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

class AddTaskViewModel: ViewModel(), KoinComponent, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

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