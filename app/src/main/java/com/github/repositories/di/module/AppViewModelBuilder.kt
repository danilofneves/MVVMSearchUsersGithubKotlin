package com.github.repositories.di.module

import androidx.lifecycle.ViewModel
import com.github.repositories.ui.home.viewmodel.HomeViewModel
import com.github.repositories.di.util.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}