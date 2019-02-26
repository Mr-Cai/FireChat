package com.fire.chat.service

import android.util.Log
import com.fire.chat.util.FirestoreUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class CloudMessaging : FirebaseMessagingService() {

    override fun onNewToken(newTocken: String?) {
        super.onNewToken(newTocken)
        if (FirebaseAuth.getInstance().currentUser != null)
            addTokenToCloud(newTocken)
    }
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (remoteMessage.notification != null) {
            Log.d("FCM", remoteMessage.data.toString())
        }
    }

    companion object {
        fun addTokenToCloud(newRegistrationToken: String?) {
            if (newRegistrationToken == null) throw NullPointerException("FCM token is null.")
            FirestoreUtil.getFCMRegistrationTokens { tokens ->
                if (tokens.contains(newRegistrationToken))
                    return@getFCMRegistrationTokens
                tokens.add(newRegistrationToken)
                FirestoreUtil.setFCMRegistrationTokens(tokens)
            }
        }
    }
}
