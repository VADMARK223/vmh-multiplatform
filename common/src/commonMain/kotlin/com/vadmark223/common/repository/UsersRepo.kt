package com.vadmark223.common.repository

import com.vadmark223.common.data.User

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
interface UsersRepo {
    fun items(): List<User>
    fun getFirst(): User
}