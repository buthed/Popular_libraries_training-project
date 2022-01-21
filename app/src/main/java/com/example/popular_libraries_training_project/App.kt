package com.example.popular_libraries_training_project

import android.app.Application
import com.example.popular_libraries_training_project.di.components.AppComponent
import com.example.popular_libraries_training_project.di.components.GithubRepoSubcomponent
import com.example.popular_libraries_training_project.di.components.GithubUsersSubcomponent
import com.example.popular_libraries_training_project.di.modules.AppModule

import com.example.popular_libraries_training_project.di.scope.containers.ReposScopeContainer
import com.example.popular_libraries_training_project.di.scope.containers.UsersScopeContainer

class App : Application(), UsersScopeContainer, ReposScopeContainer {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    var usersSubcomponent: GithubUsersSubcomponent? = null

    var repoSubcomponent: GithubRepoSubcomponent? = null

    override fun onCreate() {
        super.onCreate()
        _instance = this
    }

    override fun initUsersSubcomponent() = appComponent.userSubcomponent().also {
        usersSubcomponent = it
    }

    override fun destroyUsersSubcomponent() {
        usersSubcomponent = null
    }

    override fun initRepoSubcomponent() = appComponent.userSubcomponent().repoSubcomponent().also {
        repoSubcomponent = it
    }

    override fun destroyRepoSubcomponent() {
        repoSubcomponent = null
    }

    companion object {

        private var _instance: App? = null
        val instance
            get() = _instance!!
    }
}
