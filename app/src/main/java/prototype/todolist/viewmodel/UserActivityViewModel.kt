package prototype.todolist.viewmodel

import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import prototype.todolist.repositories.UsersRepository
import prototype.todolist.utils.Resource

class UserActivityViewModel() : ViewModel() {

    private val usersRepository = UsersRepository()

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = usersRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}