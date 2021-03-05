package com.github.repositories.core

import com.github.repositories.di.components.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component = DaggerCoreComponent
                .builder()
                .application(this)
                .build()
        component.inject(this)
        return component
    }
}