package com.vadmark223.common.repository

import androidx.compose.runtime.mutableStateListOf
import com.vadmark223.common.data.User
import kotlin.random.Random

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
class UsersRepoImpl : UsersRepo {
    private val list = mutableStateListOf<User>()

    init {
        addUser("Васильев Евгений")
        addUser("Головнев Андрей")
        addUser("Доронин Герман")
        addUser("Трищакин Михаил")
        addUser("Анисимов Роман")
        addUser("Станченко Иван")
        addUser("Маркитанов Вадим")
        addUser("Капустин Дмитрий")
        addUser("Селиверстова Кристина")
    }

    private fun addUser(fullName: String) {
        list.add(createUser(list.size, fullName))
    }

    override fun items(): List<User> {
        return list
    }

    override fun getFirst(): User {
        return list.first()
    }

    override fun createUser(id: Int, fullName: String): User {
        return User(id, fullName, Random.nextInt(0, 5))
    }

}