package prototype.todolist.repositories

import androidx.lifecycle.MutableLiveData
import prototype.todolist.dao.TasksDao
import prototype.todolist.models.Task

class TasksRepository () {

    private val tasksDao = TasksDao()

    suspend fun getTasks() = tasksDao.getTasks()

//
//    private suspend fun insert(task: Task) = tasksDao.insert(task)
//    private suspend fun update(task: Task) = tasksDao.update(task)
//    suspend fun  delete(taskId: Int) = tasksDao.delete(taskId)
//
//
//
//
//
//    suspend fun findById(id: Int) = tasksDao.findById(id)
//    suspend fun newTask(): Task {
//        return Task(0,"",0,System.currentTimeMillis())
//    }
//
//    suspend fun save(task: Task) {
//
//        if(task.id == 0){
//            this.insert(task)
//        }else{
//            this.update(task)
//        }
//    }
}