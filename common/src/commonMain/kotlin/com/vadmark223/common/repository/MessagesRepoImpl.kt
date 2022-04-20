package com.vadmark223.common.repository

import androidx.compose.runtime.mutableStateListOf
import com.vadmark223.common.data.Message

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
class MessagesRepoImpl : MessagesRepo {
    private val list = mutableStateListOf<Message>()

    init {
        for (x in 0..20) {
            list.add(Message(x, "Message $x"))
        }
    }

    override fun items(): List<Message> {
        return list
    }

    override fun addItem(item: Message) {
        list.add(item)
    }

    override fun clear() {
        list.clear()
    }
}