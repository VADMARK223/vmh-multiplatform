package com.vadmark223.common.repository

import androidx.compose.runtime.mutableStateListOf
import com.vadmark223.common.data.Message
import kotlin.random.Random

/**
 * @author Markitanov Vadim
 * @since 20.04.2022
 */
class MessagesRepoImpl : MessagesRepo {
    private val list = mutableStateListOf<Message>()
    private val userMessageMap = mutableMapOf<Int, List<Message>>()

    init {
        val list0 = mutableStateListOf<Message>()
        for (x in 0..Random.nextInt(1,20)) {
            list0.add(Message(x, "Message $x"))
        }
        userMessageMap[0] = list0

        val list1 = mutableStateListOf<Message>()
        for (x in 0..Random.nextInt(1,20)) {
            list1.add(Message(x, "Message $x"))
        }
        userMessageMap[1] = list1

        val list2 = mutableStateListOf<Message>()
        for (x in 0..Random.nextInt(1,20)) {
            list2.add(Message(x, "Message $x"))
        }
        userMessageMap[2] = list2

        val list3 = mutableStateListOf<Message>()
        for (x in 0..Random.nextInt(1,20)) {
            list3.add(Message(x, "Message $x"))
        }
        userMessageMap[3] = list3

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

    override fun updateByUserId(userId:Int) {
//        list.clear()
        userMessageMap[userId]?.let { list.addAll(it) }
    }
}