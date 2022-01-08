package com.example.popular_libraries_training_project.di.components

import com.example.popular_libraries_training_project.di.modules.*
import com.example.popular_libraries_training_project.ui.main.MainActivity
import com.example.popular_libraries_training_project.ui.main.MainPresenter
import com.example.popular_libraries_training_project.ui.repositories.RepositoriesPresenter
import com.example.popular_libraries_training_project.ui.repositories.RepositoriesPresenterFactory
import com.example.popular_libraries_training_project.ui.repository_details.RepositoryDetailsPresenter
import com.example.popular_libraries_training_project.ui.repository_details.RepositoryDetailsPresenterFactory
import com.example.popular_libraries_training_project.ui.users.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
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

    fun mainPresenter(): MainPresenter

    fun usersPresenter(): UsersPresenter

    fun repositoriesPresenterFactory(): RepositoriesPresenterFactory

    fun repositoryDetailsPresenterFactory(): RepositoryDetailsPresenterFactory

    fun inject(mainActivity: MainActivity)

    //fun inject(repositoriesPresenter: RepositoriesPresenter)

    //fun inject(repositoryDetailsPresenter: RepositoryDetailsPresenter)
}