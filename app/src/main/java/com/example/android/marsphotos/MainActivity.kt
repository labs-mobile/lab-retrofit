/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.marsphotos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.marsphotos.databinding.ActivityMainBinding
import com.example.android.marsphotos.data.TaskRepository
import com.example.android.marsphotos.ui.TaskAdapter


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