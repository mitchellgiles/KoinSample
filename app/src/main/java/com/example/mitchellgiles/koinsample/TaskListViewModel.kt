package com.example.mitchellgiles.koinsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.mitchellgiles.koinsample.data.Repository
import com.example.mitchellgiles.koinsample.data.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import kotlin.coroutines.CoroutineContext

class TaskListViewModel(private val repo: Repository): ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun getTask(title: String): LiveData<Task> = repo.getTask(title)

    fun getTasks(): LiveData<List<Task>> = repo.getTasks()

    fun deleteTask(task: Task) = launch { repo.deleteTask(task) }

    override fun onCleared() {
        job.cancel()
    }

}