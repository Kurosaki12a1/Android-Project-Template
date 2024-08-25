package com.android.template.di

import android.content.Context
import com.android.template.data.data_source.local.preferences.AppPreferences
import com.android.template.data.repository.ExampleRepositoryImpl
import com.android.template.data.repository.PreferencesRepositoryImpl
import com.android.template.domain.repository.ExampleRepository
import com.android.template.domain.repository.PreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideExampleRepository(@ApplicationContext context: Context): ExampleRepository =
        ExampleRepositoryImpl(context)

    @Provides
    @Singleton
    fun providePreferencesRepository(appPreferences: AppPreferences): PreferencesRepository =
        PreferencesRepositoryImpl(appPreferences)
}