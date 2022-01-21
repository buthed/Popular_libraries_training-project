package com.example.popular_libraries_training_project.di.scope.containers

import com.example.popular_libraries_training_project.di.components.GithubRepoSubcomponent

interface ReposScopeContainer {

    fun initRepoSubcomponent(): GithubRepoSubcomponent

    fun destroyRepoSubcomponent()
}