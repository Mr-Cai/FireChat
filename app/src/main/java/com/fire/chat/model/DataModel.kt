@file:Suppress("unused")

package com.fire.chat.model

import com.fire.chat.AppConstants
import java.util.*


data class ChatChannel(val userIds: MutableList<String>) {
    constructor() : this(mutableListOf())
}

data class ImageMessage(val imagePath: String,
                        override val time: Date,
                        override val senderId: String,
                        override val recipientId: String,
                        override val senderName: String,
                        override val type: String = AppConstants.IMAGE)
    : Message {
    constructor() : this("", Date(0), "", "", "")
}

data class TextMessage(val text: String,
                       override val time: Date,
                       override val senderId: String,
                       override val recipientId: String,
                       override val senderName: String,
                       override val type: String = AppConstants.TEXT)
    : Message {
    constructor() : this("", Date(0), "", "", "")
}

data class User(val name: String,
                val bio: String,
                val profilePicturePath: String?,
                val registrationTokens: MutableList<String>) {
    constructor() : this("", "", null, mutableListOf())
}