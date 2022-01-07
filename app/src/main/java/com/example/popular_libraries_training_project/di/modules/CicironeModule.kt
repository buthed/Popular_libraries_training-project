package com.example.popular_libraries_training_project.di.modules

import com.example.popular_libraries_training_project.navigation.AppScreens
import com.example.popular_libraries_training_project.navigation.AppScreensImpl
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class CicironeModule {

    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

    @Provides
    fun navigatorHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    @Provides
    fun router(): Router {
        return cicerone.router
    }

    @Provides
    fun appScreens(): AppScreens {
        return AppScreensImpl()
    }
}