package com.android.template.presenter.home

import androidx.fragment.app.viewModels
import com.android.template.common.base.BaseFragment
import com.android.template.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel: HomeViewModel by viewModels()

    override fun initView() {
        viewModel.doExample()
    }

    override fun observeData() {

    }
}