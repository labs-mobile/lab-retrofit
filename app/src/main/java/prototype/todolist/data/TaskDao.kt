package prototype.todolist.data

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TaskDao {


    var reasult_tasks : MutableLiveData<MutableList<TaskEntry>> = MutableLiveData(mutableListOf<TaskEntry>())


    companion object {
        private var task_count = 0
        private var list_tasks : MutableList<TaskEntry> = mutableListOf<TaskEntry>()

        init {
            for( i in 1..10){

                val task = TaskEntry(++task_count,"Task $i",1,System.currentTimeMillis())
                list_tasks.add(0,task)
            }
        }
    }


    fun insert(taskEntry: TaskEntry){
        taskEntry.id = ++TaskDao.task_count
        TaskDao.list_tasks.add(0,taskEntry)
     }

     fun delete(id: Int){
        var index = this.findIndexById(id)
         list_tasks.removeAt(index)
     }

     fun update(taskEntry: TaskEntry){
         var index = this.findIndexById(taskEntry.id);
         TaskDao.list_tasks[index] = taskEntry
     }

    private fun findIndexById(id: Int): Int {
        val index = TaskDao.list_tasks.withIndex().filter { it.value.id == id }.map{it.index}.first()
        return index
    }


    fun getAllTasks() {

        val BASE_URL = "https://jsonplaceholder.typicode.com/"

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(TaskApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<TaskEntry>?> {
            override fun onResponse(
                call: Call<List<TaskEntry>?>,
                response: Response<List<TaskEntry>?>
            ) {
                reasult_tasks.value = response.body()!!.toMutableList()
            }

            override fun onFailure(call: Call<List<TaskEntry>?>, t: Throwable) {
                val msg = "on Failure " + t.message
            }
        })


//        return TaskDao.list_tasks
    }

    fun findById(id: Int) :TaskEntry {
        val task = TaskDao.list_tasks.filter { it.id == id }.first()
        return task
    }


}