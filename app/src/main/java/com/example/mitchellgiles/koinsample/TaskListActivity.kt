package com.example.mitchellgiles.koinsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_task_list.*
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import org.koin.android.viewmodel.ext.android.viewModel


class TaskListActivity : AppCompatActivity(), TaskAdapter.TaskAdapterOnClickHandler {

    val taskListViewModel: TaskListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)


        fab.setOnClickListener { view ->
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }

        val taskAdapter = TaskAdapter(this, this)

        taskListViewModel.getTasks().observe(this, Observer {
            if (it != null) taskAdapter.setTaskList(it)
        })

        val layoutManager = LinearLayoutManager(this)

        taskRecyclerView.layoutManager = layoutManager
        taskRecyclerView.hasFixedSize()
        taskRecyclerView.adapter = taskAdapter

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }


            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                val position = viewHolder.adapterPosition
                val task = taskAdapter.getTaskList()[position]
                taskListViewModel.deleteTask(task)
                }
            }).attachToRecyclerView(taskRecyclerView)
    }



    override fun onClick(title: String) {
        val intent = Intent(this, AddTaskActivity::class.java)
        intent.putExtra("title", title)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        Log.d("Test", "On Resume was called")
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus) Log.d("Test", "Focus was changed")
    }
}
