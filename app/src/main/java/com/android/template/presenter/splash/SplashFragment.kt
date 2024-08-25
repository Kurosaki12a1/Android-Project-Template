package com.android.template.presenter.splash

import androidx.fragment.app.viewModels
import com.android.template.common.base.BaseFragment
import com.android.template.databinding.FragmentSplashBinding
import com.android.template.extension.collectFlow
import com.android.template.navigation.NavigationScreen
import dagger.hilt.android.AndroidEntryPoint

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>(
    inflater = FragmentSplashBinding::inflate
) {
    override val viewModel: SplashViewModel by viewModels()

    override fun initView() {
        viewModel.startTimer()
    }

    override fun observeData() {
        collectFlow(viewModel.navigateToHome) {
            if (it) {
                println("Vào đây không")
                navigateTo(NavigationScreen.HomeScreen)
            }
        }
    }

}