package com.example.popular_libraries_training_project.di.scope.containers

import com.example.popular_libraries_training_project.di.components.GithubUsersSubcomponent

interface UsersScopeContainer {

    fun initUsersSubcomponent(): GithubUsersSubcomponent

    fun destroyUsersSubcomponent()
}