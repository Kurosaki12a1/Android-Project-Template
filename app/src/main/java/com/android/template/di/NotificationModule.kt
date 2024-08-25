package com.android.template.di

import android.app.NotificationManager
import android.content.Context
import com.android.template.framework.notification.ExampleNotification
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NotificationModule {

    @Provides
    fun provideNotificationManager(
        @ApplicationContext context: Context
    ): NotificationManager {
        return context.getSystemService(NotificationManager::class.java)
    }

    @Provides
    fun provideExampleNotification(
        @ApplicationContext context: Context,
        notificationManager: NotificationManager
    ): ExampleNotification {
        return ExampleNotification(
            context = context,
            notificationManager = notificationManager
        )
    }

}