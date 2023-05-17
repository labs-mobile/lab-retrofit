package prototype.todolist.viewmodel

import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import prototype.todolist.repositories.TasksRepository
import prototype.todolist.repositories.UsersRepository
import prototype.todolist.utils.Resource

class TaskActivityViewModel() : ViewModel() {

    private val tasksRepository = TasksRepository()

    fun getTasks() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = tasksRepository.getTasks()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
    
}