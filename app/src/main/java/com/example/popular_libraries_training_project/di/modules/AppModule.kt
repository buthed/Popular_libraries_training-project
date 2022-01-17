package com.example.popular_libraries_training_project.di.modules

import android.app.Application
import android.content.Context
import com.example.popular_libraries_training_project.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Singleton
    @Provides
    fun context(): Context {
        return app
    }

    @Singleton
    @Provides
    fun app(): App {
        return app
    }
}