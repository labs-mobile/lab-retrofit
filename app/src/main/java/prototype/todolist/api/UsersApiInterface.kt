package prototype.todolist.api

import prototype.todolist.models.User
import retrofit2.http.GET

interface UsersApiInterface {

    @GET("users")
    suspend fun getUsers(): List<User>

}