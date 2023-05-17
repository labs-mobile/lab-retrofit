package prototype.todolist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import prototype.todolist.repositories.TasksRepository
import prototype.todolist.databinding.ActivityTasksBinding
import prototype.todolist.databinding.ActivityUsersBinding
import prototype.todolist.models.Task
import prototype.todolist.models.User
import prototype.todolist.ui.TaskRecyclerViewAdapter
import prototype.todolist.ui.UserRecyclerViewAdapter
import prototype.todolist.utils.Status
import prototype.todolist.viewmodel.TaskActivityViewModel
import prototype.todolist.viewmodel.UserActivityViewModel


class TasksActivity : AppCompatActivity() {

    private val viewModel: TaskActivityViewModel by viewModels()
    private lateinit var adapter: TaskRecyclerViewAdapter
    private lateinit var binding: ActivityTasksBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        // ViewBinding
        super.onCreate(savedInstanceState)
        val binding = ActivityTasksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init recyclerView
        binding.apply {

            adapter = TaskRecyclerViewAdapter(arrayListOf())
            recyclerView.layoutManager = LinearLayoutManager(this@TasksActivity)
            recyclerView.adapter =  adapter
            floatingActionButton.setOnClickListener{
////                val repository = TaskRepository()
////                val newTask = repository.newTask();
////                newTask.title = "New task" + Random.nextInt()
////                repository.save(newTask)
//                repository.getAllTasks()
//                Toast.makeText(applicationContext,"Ajouter une tâche", Toast.LENGTH_LONG).show()
//                taskRecyclerViewAdapter.notifyDataSetChanged()
            }
        }


        // getUsers observe
        viewModel.getTasks().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    retrieveList(it.data!!)
                }
                Status.ERROR -> {
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
            }
        })

    }

    private fun retrieveList(tasks: List<Task>) {
        adapter.apply {
            addTasks(tasks)
            notifyDataSetChanged()
        }
    }


}