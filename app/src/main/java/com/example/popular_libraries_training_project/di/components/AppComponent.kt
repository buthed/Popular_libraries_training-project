package com.example.popular_libraries_training_project.di.components

import com.example.popular_libraries_training_project.di.modules.*
import com.example.popular_libraries_training_project.ui.main.MainActivity
import com.example.popular_libraries_training_project.ui.main.MainPresenter
import com.example.popular_libraries_training_project.ui.repository_details.RepositoryDetailsPresenterFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DbModule::class,
        CicironeModule::class,
        AppModule::class,
        NetworkModule::class
    ]
)

interface AppComponent {

    fun userSubcomponent(): GithubUsersSubcomponent

    fun mainPresenter(): MainPresenter

    //fun repositoryDetailsPresenterFactory(): RepositoryDetailsPresenterFactory

    fun inject(mainActivity: MainActivity)
}