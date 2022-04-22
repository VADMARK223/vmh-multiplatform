package com.vadmark223.common.repository

import com.vadmark223.common.data.Message

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
interface MessagesRepo {
    fun messageList(): List<Message>
    fun addMessage(item: Message)
    fun clearMessages()
    fun updateMessagesByUserId(userId: Int)
    fun messagesByUserId(userId: Int): List<Message>
}