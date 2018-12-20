package com.example.mitchellgiles.koinsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.mitchellgiles.koinsample.data.Task

import kotlinx.android.synthetic.main.activity_add_task.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel


class AddTaskActivity : AppCompatActivity() {

    val addTaskViewModel: AddTaskViewModel by viewModel()
    private var intentExtra: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

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

        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()
        Log.d("Test", "has been saved? maybe")
        this.finish()
    }

}
