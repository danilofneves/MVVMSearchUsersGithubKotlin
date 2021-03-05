package com.github.repositories.ui.home.view

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun provideMainMenuFragment(): HomeFragment?
}