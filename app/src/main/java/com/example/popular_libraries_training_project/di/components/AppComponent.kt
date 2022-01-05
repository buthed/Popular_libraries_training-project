package com.example.popular_libraries_training_project.di.components

import com.example.popular_libraries_training_project.di.modules.*
import com.example.popular_libraries_training_project.ui.main.MainActivity
import com.example.popular_libraries_training_project.ui.main.MainPresenter
import com.example.popular_libraries_training_project.ui.repositories.RepositoriesPresenter
import com.example.popular_libraries_training_project.ui.repository_details.RepositoryDetailsPresenter
import com.example.popular_libraries_training_project.ui.users.UsersPresenter
import dagger.Component

@Component(
    modules = [
        CacheModule::class,
        CicironeModule::class,
        ContextModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)

    fun inject(usersPresenter: UsersPresenter)

    fun inject(repositoriesPresenter: RepositoriesPresenter)

    fun inject(repositoryDetailsPresenter: RepositoryDetailsPresenter)
}