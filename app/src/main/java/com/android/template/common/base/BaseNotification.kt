package com.android.template.common.base

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager

abstract class BaseNotification(
    private val notificationManager: NotificationManager
) {
    abstract val notificationChannelId: String
    abstract val notificationChannelName: String
    abstract val notificationId: Int

    fun showNotification() {
        val channel = createNotificationChannel()
        notificationManager.createNotificationChannel(channel)

        val notification = buildNotification()
        notificationManager.notify(notificationId, notification)
    }

    open fun createNotificationChannel(
        importance: Int = NotificationManager.IMPORTANCE_DEFAULT
    ): NotificationChannel {
        return NotificationChannel(
            notificationChannelId,
            notificationChannelName,
            importance
        )
    }

    abstract fun buildNotification(): Notification

    protected abstract fun getNotificationTitle(): String

    protected abstract fun getNotificationMessage(): String
}