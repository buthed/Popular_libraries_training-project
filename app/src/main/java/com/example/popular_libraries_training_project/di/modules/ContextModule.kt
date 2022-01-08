package com.example.popular_libraries_training_project.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(val app: Application) {

    @Singleton
    @Provides
    fun app(): Context {
        return app
    }
}