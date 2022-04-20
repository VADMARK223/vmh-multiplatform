package com.vadmark223.common.repository

import com.vadmark223.common.data.Message

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
class MessagesRepoImpl : MessagesRepo {
    private val messagesList: ArrayList<Message> = arrayListOf()

    init {
        for (x in 0..50) {
            messagesList.add(Message(x, "Message $x"))
        }
    }

    override fun items(): List<Message> {
        return messagesList
    }

    override fun addItem(item: Message) {
        messagesList.add(item)
    }
}