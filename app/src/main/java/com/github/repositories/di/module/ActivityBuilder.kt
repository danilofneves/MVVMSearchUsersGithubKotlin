package com.github.repositories.di.module

import com.github.repositories.ui.home.view.MainActivity
import com.github.repositories.ui.home.view.MainFragmentBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainFragmentBindingModule::class])
    abstract fun bindMainActivity(): MainActivity

}