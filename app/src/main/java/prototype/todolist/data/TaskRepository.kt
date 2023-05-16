package prototype.todolist.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class TaskRepository () {

    var reasultComplet : MutableLiveData<Boolean> = MutableLiveData(false)



    val taskDao = TaskDao()
    private fun insert(taskEntry: TaskEntry) = taskDao.insert(taskEntry)
    private fun update(taskEntry: TaskEntry) = taskDao.update(taskEntry)
    fun delete(taskId: Int) = taskDao.delete(taskId)


    fun getAllTasks(){
        this.taskDao.getAllTasks()
    }


    fun findById(id: Int) = taskDao.findById(id)
    fun newTask(): TaskEntry {
        return TaskEntry(0,"",0,System.currentTimeMillis())
    }

    fun save(taskEntry: TaskEntry) {

        if(taskEntry.id == 0){
            this.insert(taskEntry)
        }else{
            this.update(taskEntry)
        }
    }
}