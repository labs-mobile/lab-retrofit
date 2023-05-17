package prototype.todolist.dao

import prototype.todolist.api.UsersApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UsersDao {


    companion object{

        private const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() //Doesn't require the adapter
        }

        val apiService: UsersApiInterface = getRetrofit().create(UsersApiInterface::class.java)
    }

    suspend fun getUsers() = UsersDao.apiService.getUsers()

}