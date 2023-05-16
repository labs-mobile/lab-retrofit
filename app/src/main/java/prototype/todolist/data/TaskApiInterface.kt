package prototype.todolist.data

import retrofit2.Call
import retrofit2.http.GET

interface TaskApiInterface {

    @GET("posts")
    fun getData() : Call<List<TaskEntry>>
}
