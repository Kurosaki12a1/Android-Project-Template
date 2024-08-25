package com.android.template.framework.notification

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.android.template.R
import com.android.template.common.base.BaseNotification
import com.android.template.presenter.MainActivity
import javax.inject.Inject

class ExampleNotification @Inject constructor(
    private val context: Context,
    notificationManager: NotificationManager
) : BaseNotification(notificationManager) {
    override val notificationChannelId: String
        get() = "example_channel_id"

    override val notificationChannelName: String
        get() = "Example Channel"

    override val notificationId: Int
        get() = 100

    override fun buildNotification(): Notification {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(context, notificationChannelId)
            .setContentTitle(getNotificationTitle())
            .setContentText(getNotificationMessage())
            .setStyle(NotificationCompat.BigTextStyle().bigText(getNotificationMessageBigStyle()))
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()
    }

    override fun getNotificationTitle(): String {
        return "Example Title"
    }

    override fun getNotificationMessage(): String {
        return "Example Notification Message"
    }

    private fun getNotificationMessageBigStyle(): String {
        return "This is an example notification message with a big style."
    }
}