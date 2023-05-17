package prototype.todolist.repositories

import prototype.todolist.api.UsersApiInterface
import prototype.todolist.dao.UsersDao

class UsersRepository() {

    private val usersDao = UsersDao()

    suspend fun getUsers() = usersDao.getUsers()
}