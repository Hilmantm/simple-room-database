package id.example.local_database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import id.example.local_database.dao.UserDao
import id.example.local_database.database.AppDatabase
import id.example.local_database.entity.User
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class UserRepository(application: Application) {

    private val userDao: UserDao = AppDatabase.getDatabase(application).userDao()
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    fun getAll(): LiveData<List<User>> {
        return userDao.getAll()
    }

    fun insertNewUser(user: User) {
        executorService.execute{ userDao.insertNewUser(user) }
    }

}