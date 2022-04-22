package com.vadmark223.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import com.vadmark223.common.App
import com.vadmark223.common.repository.UsersRepo
import com.vadmark223.common.repository.UsersRepoImpl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val usersRepo: UsersRepo = UsersRepoImpl()
                usersRepo.addUser("Евгений", "Васильев")
                usersRepo.addUser("Андрей", "Головнев")
                usersRepo.addUser("Герман","Доронин")
                usersRepo.addUser("Михаил", "Трищакин")
                usersRepo.addUser("Роман", "Анисимов")
                usersRepo.addUser("Иван", "Станченко")
                usersRepo.addUser("Вадим", "Маркитанов")
                usersRepo.addUser("Дмитрий","Капустин")
                usersRepo.addUser("Кристина", "Селиверстова")
                App(usersRepo)
            }
        }
    }
}