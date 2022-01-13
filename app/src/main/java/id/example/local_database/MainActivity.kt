package id.example.local_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.example.local_database.entity.User
import id.example.local_database.repository.UserRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = UserRepository(application)

        val newUser = User(uid = 1, firstName = "Hilman", lastName = "Taris")
        repository.insertNewUser(newUser)

        val newUser2 = User(uid = 2, firstName = "Daffa", lastName = "Fauzan")
        repository.insertNewUser(newUser2)

    }
}