package prototype.todolist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import prototype.todolist.data.TaskRepository
import prototype.todolist.databinding.ActivityMainBinding
import prototype.todolist.ui.TaskAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = TaskRepository()
        repository.getAllTasks()

        repository.taskDao.reasult_tasks.observe(this, Observer {
            binding.recyclerView.adapter!!.notifyDataSetChanged()
        })


        binding.apply {

            val taskAdapter = TaskAdapter(repository)
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.adapter =  taskAdapter
            floatingActionButton.setOnClickListener{

//                val repository = TaskRepository()
//                val newTask = repository.newTask();
//                newTask.title = "New task" + Random.nextInt()
//                repository.save(newTask)
                repository.getAllTasks()
                Toast.makeText(applicationContext,"Ajouter une tâche", Toast.LENGTH_LONG).show()
                taskAdapter.notifyDataSetChanged()
            }

        }

    }


}