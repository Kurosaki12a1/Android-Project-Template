package com.android.template.presenter.home

import com.android.template.common.base.BaseViewModel
import com.android.template.domain.usecase.ExampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: ExampleUseCase
) : BaseViewModel() {

    fun doExample() {
        useCase
    }
}