package com.fire.chat.model

import java.util.*

interface Message {
    val time: Date
    val senderId: String
    val recipientId: String
    val senderName: String
    val type: String
}