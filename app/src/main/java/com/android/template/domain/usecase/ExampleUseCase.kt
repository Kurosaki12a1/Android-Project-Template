package com.android.template.domain.usecase

import com.android.template.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleUseCase @Inject constructor(private val repo: ExampleRepository) {

    operator fun invoke() {
        repo.example()
    }
}