package com.github.repositories.di.module

import androidx.lifecycle.ViewModelProvider
import com.github.repositories.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [
    (AppViewModelBuilder::class)
])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}