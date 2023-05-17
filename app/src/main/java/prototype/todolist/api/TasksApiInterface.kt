package prototype.todolist.api

import prototype.todolist.models.Task
import prototype.todolist.models.User
import retrofit2.Call
import retrofit2.http.GET

interface TasksApiInterface {

    @GET("posts")
    suspend fun getTasks(): List<Task>
}
