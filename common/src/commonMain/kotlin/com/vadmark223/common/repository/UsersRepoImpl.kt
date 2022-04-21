package com.vadmark223.common.repository

import androidx.compose.runtime.mutableStateListOf
import com.vadmark223.common.data.User

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
class UsersRepoImpl : UsersRepo {
    private val list = mutableStateListOf<User>()

    init {
        list.add(User(0, "Головнев Андрей"))
        list.add(User(1, "Ималетдинов Роман"))
        list.add(User(2, "Доронин Герман"))
        list.add(User(3, "Трищакин Михаил"))
        list.add(User(4, "Анисимов Роман"))
        list.add(User(5, "Станченко Иван"))
    }

    override fun items(): List<User> {
        return list;
    }

}