package com.example.popular_libraries_training_project

import android.app.Application
import com.example.popular_libraries_training_project.di.components.AppComponent
import com.example.popular_libraries_training_project.di.components.DaggerAppComponent
import com.example.popular_libraries_training_project.di.modules.ContextModule
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Component

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    companion object {

        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}