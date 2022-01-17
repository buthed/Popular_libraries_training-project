package com.example.popular_libraries_training_project.di.components

import com.example.popular_libraries_training_project.di.modules.GithubRepoModule
import com.example.popular_libraries_training_project.di.scope.RepositoryScope
import com.example.popular_libraries_training_project.ui.repositories.RepositoriesPresenterFactory
import dagger.Subcomponent

@RepositoryScope
@Subcomponent(
    modules = [
        GithubRepoModule::class
    ]
)
interface GithubRepoSubcomponent {

    fun repositoriesPresenterFactory(): RepositoriesPresenterFactory
}