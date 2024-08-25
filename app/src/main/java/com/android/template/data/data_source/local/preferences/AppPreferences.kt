package com.android.template.data.data_source.local.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class AppPreferences @Inject constructor(private val context: Context) {
    companion object {
        private const val APP_PREFERENCES = "app_preferences"
        private const val MODE = Context.MODE_PRIVATE

        private const val EXAMPLE_KEY = "example_key"
    }


    private val appPreferences: SharedPreferences =
        context.getSharedPreferences(APP_PREFERENCES, MODE)

    /**
     * SharedPreferences extension function, so we won't need to call edit() and apply()
     * ourselves on every SharedPreferences operation.
     */
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    fun putInt(key: String, value: Int) = appPreferences.edit {
        it.putInt(key, value)
    }

    fun getInt(key: String, defaultValue: Int = 0) = appPreferences.getInt(key, defaultValue)

    fun putString(key: String, value: String) = appPreferences.edit {
        it.putString(key, value)
    }

    fun getString(key: String, defaultValue: String = "") =
        appPreferences.getString(key, defaultValue) ?: defaultValue

    var exampleValue: String
        get() = getString(EXAMPLE_KEY, "")
        set(value) = putString(EXAMPLE_KEY, value)

    fun clearPreferences() {
        appPreferences.edit {
            it.clear().apply()
        }
    }
}