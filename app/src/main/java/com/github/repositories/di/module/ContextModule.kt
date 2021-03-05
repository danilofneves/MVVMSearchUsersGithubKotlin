package com.github.repositories.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module(includes = [ViewModelBuilder::class])
abstract class ContextModule {

    @Binds
    abstract fun provideContext(application: Application): Context
}