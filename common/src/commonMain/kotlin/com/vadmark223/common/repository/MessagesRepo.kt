package com.vadmark223.common.repository

import com.vadmark223.common.data.Message

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
interface MessagesRepo {
    fun items(): List<Message>
    fun addItem(item: Message)
}