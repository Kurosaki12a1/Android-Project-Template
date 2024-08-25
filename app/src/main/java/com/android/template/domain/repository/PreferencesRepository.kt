package com.android.template.domain.repository

interface PreferencesRepository {
    fun getValue(): String
    fun setValue(value: String)
}