package com.android.template.di

import com.android.template.domain.repository.ExampleRepository
import com.android.template.domain.usecase.ExampleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideExampleUseCase(repo : ExampleRepository) : ExampleUseCase = ExampleUseCase(repo)
}