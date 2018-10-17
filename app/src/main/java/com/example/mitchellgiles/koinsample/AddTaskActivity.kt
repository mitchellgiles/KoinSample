package com.example.mitchellgiles.koinsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.mitchellgiles.koinsample.data.Task

import kotlinx.android.synthetic.main.activity_add_task.*


class AddTaskActivity : AppCompatActivity() {

    private lateinit var addTaskViewModel: AddTaskViewModel
    private var intentExtra: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        this.addTaskViewModel = ViewModelProviders.of(this).get(AddTaskViewModel::class.java)

        this.intentExtra = intent?.getStringExtra("title") ?: ""

        if(intentExtra != "") addTaskViewModel.getTask(intentExtra).observe(this, Observer {
            taskTitle.setText(it?.title)
            taskDetails.setText(it?.details)
            taskPriority.setText(it?.priority)
        })


    }

    fun save(view: View) {
        val task = Task(taskTitle.text.toString(), taskDetails.text.toString(), taskPriority.text.toString())
        if (intentExtra != "") addTaskViewModel.updateTask(task, intentExtra) else addTaskViewModel.addTask(task)

        Log.d("Test", "has been saved? maybe")
        this.finish()
    }
}
