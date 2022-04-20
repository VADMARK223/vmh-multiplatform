package com.vadmark223.common.data

import kotlin.random.Random

/**
 * @author Markitanov Vadim
 * @since 16.04.2022
 */
data class Message(val id:Int, val text:String, val isMy:Boolean= Random.nextBoolean())