package com.vadmark223.common.repository

import androidx.compose.runtime.mutableStateListOf
import com.vadmark223.common.data.Message
import com.vadmark223.common.data.User
import kotlin.random.Random

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
class MessagesRepoImpl(usersRepo: UsersRepo) : MessagesRepo {
    private val messages = mutableStateListOf<Message>()
    private val userMessageMap = mutableMapOf<Int, List<Message>>()

    init {
        usersRepo.items().forEach { user ->
            userMessageMap[userMessageMap.size] = createRandomMessages(user)
        }

        messages.addAll(userMessageMap[0] ?: mutableStateListOf())
    }

    private fun createRandomMessages(user: User): List<Message> {
        val result = mutableStateListOf<Message>()
        for (x in 0..Random.nextInt(1, 20)) {
            result.add(Message(x, "${user.fullName} $x"))
        }

        return result
    }

    override fun messageList(): List<Message> {
        return messages
    }

    override fun addMessage(item: Message) {
        messages.add(item)
    }

    override fun clearMessages() {
        messages.clear()
    }

    override fun updateByUserId(userId: Int) {
        clearMessages()
        userMessageMap[userId]?.let { messages.addAll(it) }
    }

    override fun messagesByUserId(userId: Int): List<Message> {
        return userMessageMap[userId]!!
    }
}