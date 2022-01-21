package com.example.popular_libraries_training_project.di.components

import com.example.popular_libraries_training_project.di.modules.GithubUserModule
import com.example.popular_libraries_training_project.di.scope.UsersScope
import com.example.popular_libraries_training_project.ui.users.UsersPresenter
import dagger.Subcomponent

@UsersScope
@Subcomponent(
    modules = [
        GithubUserModule::class
    ]
)
interface GithubUsersSubcomponent {

    fun repoSubcomponent(): GithubRepoSubcomponent

    fun provideUsersPresenter(): UsersPresenter
}