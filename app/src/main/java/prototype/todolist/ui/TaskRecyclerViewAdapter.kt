package prototype.todolist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import prototype.todolist.R
import prototype.todolist.models.Task
import prototype.todolist.models.User
import prototype.todolist.repositories.TasksRepository


class TaskRecyclerViewAdapter(private val tasks: ArrayList<Task>) : RecyclerView.Adapter<TaskRecyclerViewAdapter.DataViewHolder>() {

    class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val taskTitle: TextView = view.findViewById<Button>(R.id.taskTitle)
        val taskPriority: TextView = view.findViewById<Button>(R.id.taskPriority)
        val taskTimestamp: TextView = view.findViewById<Button>(R.id.taskTimestamp)
        val cardView: CardView = view.findViewById(R.id.cardview)

        fun bind(task: Task) {
            taskTitle.text = task.title
            taskPriority.text = task.priority.toString()
            taskTimestamp.text = task.timestamp.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return DataViewHolder(layout)
    }

    override fun getItemCount(): Int  = tasks.size
    override fun onBindViewHolder(dataViewHolder: DataViewHolder, position: Int) {

        dataViewHolder.bind(tasks[position])

        dataViewHolder.cardView.setOnClickListener {

//            task.title = task.title + "+"
//            // Todo : supprimer ces deux lignes et voir est ce que RecyclerView continue d'afficher les updates ?
//            val repository = TasksRepository()
//            repository.save(task)
//            this.notifyDataSetChanged()
//
//            // Todo : Afficher un message aprés Update
//            // Toast.makeText(context,"Update $task", Toast.LENGTH_LONG).show()
        }
    }

    fun addTasks(tasks: List<Task>) {
        this.tasks.apply {
            clear()
            addAll(tasks)
        }

    }

}