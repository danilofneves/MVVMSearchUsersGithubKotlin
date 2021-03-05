package com.github.repositories.di.components

import android.app.Application
import com.github.repositories.core.BaseApp
import com.github.repositories.di.module.ActivityBuilder
import com.github.repositories.di.module.ApiServiceModule
import com.github.repositories.di.module.ContextModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,  ActivityBuilder::class, ContextModule::class, ApiServiceModule::class])
interface CoreComponent : AndroidInjector<BaseApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): CoreComponent
    }

}