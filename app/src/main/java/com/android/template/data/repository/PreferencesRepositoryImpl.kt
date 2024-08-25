package com.android.template.data.repository

import com.android.template.data.data_source.local.preferences.AppPreferences
import com.android.template.domain.repository.PreferencesRepository
import javax.inject.Inject

class PreferencesRepositoryImpl @Inject constructor(private val appPreferences: AppPreferences) :
    PreferencesRepository {

    override fun getValue(): String {
        return appPreferences.exampleValue
    }

    override fun setValue(value: String) {
        appPreferences.exampleValue = value
    }
}