package com.example.mitchellgiles.koinsample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mitchellgiles.koinsample.data.Task

class TaskAdapter(private val context: Context, private val clickHandler: TaskAdapterOnClickHandler):
    RecyclerView.Adapter<TaskAdapter.TaskAdapterViewHolder>() {

    private lateinit var taskList: List<Task>

    interface TaskAdapterOnClickHandler {
        fun onClick(title: String)
    }

    inner class TaskAdapterViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

        var titleTextView: TextView
        var priorityTextView: TextView

        init {
            titleTextView = view.findViewById(R.id.taskItemTitle)
            priorityTextView = view.findViewById(R.id.taskItemPriority)
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val adapterPosition = adapterPosition
            val title = taskList[adapterPosition].title
            clickHandler.onClick(title)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TaskAdapterViewHolder {
        val context = viewGroup.context

        val layouIdForListItem = R.layout.task_item
        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(layouIdForListItem, viewGroup, false)
        return TaskAdapterViewHolder(view)

    }

    override fun onBindViewHolder(holder: TaskAdapterViewHolder, position: Int) {
        val currentTask = taskList[position]

        holder.titleTextView.setText(currentTask.title)
        holder.priorityTextView.setText(currentTask.priority)
    }

    override fun getItemCount(): Int = if (::taskList.isInitialized) taskList.size else 0

    fun setTaskList(tasks: List<Task>) {
        taskList = tasks
        notifyDataSetChanged()
    }

    fun getTaskList(): List<Task> = this.taskList

}