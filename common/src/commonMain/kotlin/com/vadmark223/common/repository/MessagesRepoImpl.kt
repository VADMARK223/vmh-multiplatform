package com.vadmark223.common.repository

import androidx.compose.runtime.mutableStateListOf
import com.vadmark223.common.data.Message
import kotlin.random.Random

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
class MessagesRepoImpl : MessagesRepo {
    private val messages = mutableStateListOf<Message>()
    private val userMessageMap = mutableMapOf<Int, List<Message>>()

    init {
        userMessageMap[userMessageMap.size] = createRandomMessages()
//        userMessageMap[userMessageMap.size] = createRandomMessages()
//        userMessageMap[userMessageMap.size] = createRandomMessages()
//        userMessageMap[userMessageMap.size] = createRandomMessages()
//        userMessageMap[userMessageMap.size] = createRandomMessages()
//        userMessageMap[userMessageMap.size] = createRandomMessages()

        if (userMessageMap.isNotEmpty()) {
            messages.addAll(userMessageMap[0]!!)
        }
    }

    private fun createRandomMessages(): List<Message> {
        val result = mutableStateListOf<Message>()
        for (x in 0..Random.nextInt(1, 20)) {
            result.add(Message(x, "Message $x"))
        }

        return result
    }

    override fun messageList(): List<Message> {
        return messages
    }

    override fun addItem(item: Message) {
        messages.add(item)
    }

    override fun clear() {
        messages.clear()
    }

    override fun updateByUserId(userId: Int) {
        clear()
        userMessageMap[userId]?.let { messages.addAll(it) }
    }

    override fun messagesByUserId(userId: Int): List<Message> {
        return userMessageMap[userId]!!
    }
}