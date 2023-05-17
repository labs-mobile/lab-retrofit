package prototype.todolist.dao

import androidx.lifecycle.MutableLiveData
import prototype.todolist.api.TasksApiInterface
import prototype.todolist.api.UsersApiInterface
import prototype.todolist.models.Task
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TasksDao {

    companion object{
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() //Doesn't require the adapter
        }
        val apiService: TasksApiInterface = getRetrofit().create(TasksApiInterface::class.java)
    }

    suspend fun getTasks() = apiService.getTasks()



//    companion object {
//        private var task_count = 0
//        private var list_tasks : MutableList<Task> = mutableListOf<Task>()
//
//        init {
//            for( i in 1..10){
//
//                val task = Task(++task_count,"Task $i",1,System.currentTimeMillis())
//                list_tasks.add(0,task)
//            }
//        }
//    }

//
//    suspend fun  insert(task: Task){
////        task.id = ++TasksDao.task_count
////        TasksDao.list_tasks.add(0,task)
//     }
//
//    suspend fun delete(id: Int){
////        var index = this.findIndexById(id)
////         list_tasks.removeAt(index)
//     }
//
//    suspend fun update(task: Task){
////         var index = this.findIndexById(task.id);
////         TasksDao.list_tasks[index] = task
//     }
//
//    private suspend fun findIndexById(id: Int): Int {
////        val index = TasksDao.list_tasks.withIndex().filter { it.value.id == id }.map{it.index}.first()
////        return index
//        return 0
//    }
//
//
//
//
//    fun findById(id: Int) : Task? {
////        val task = TasksDao.list_tasks.filter { it.id == id }.first()
//        return null
//    }


}