package com.android.template.data.repository

import android.content.Context
import com.android.template.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(private val context : Context) : ExampleRepository {

    override fun example() {
        println("PackageNameApp: ${context.packageName}")
    }
}