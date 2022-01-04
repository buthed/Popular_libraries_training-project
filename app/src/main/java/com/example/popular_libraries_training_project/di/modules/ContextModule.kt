package com.example.popular_libraries_training_project.di.modules

import android.app.Application
import android.content.Context
import com.example.popular_libraries_training_project.App
import dagger.Module
import dagger.Provides

@Module
class ContextModule(val app: Application) {

    @Provides
    fun app(): Context {
        return app
    }
}