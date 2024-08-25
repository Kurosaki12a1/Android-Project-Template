package com.android.template.di

import android.content.Context
import androidx.room.Room
import com.android.template.data.data_source.local.AppDatabase
import com.android.template.data.data_source.local.dao.ExampleDao
import com.android.template.data.data_source.local.preferences.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppPreferences(context: Context): AppPreferences = AppPreferences(context)

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "example_database"
        ).allowMainThreadQueries().build()
    }

    @Provides
    fun provideExampleDao(database: AppDatabase): ExampleDao {
        return database.exampleDao()
    }
}
