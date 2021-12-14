package com.example.popular_libraries_training_project.screens

import com.example.popular_libraries_training_project.domain.GithubReposRepository
import com.example.popular_libraries_training_project.model.GithubReposModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.ui.repositories.RepositoriesFragment
import com.example.popular_libraries_training_project.ui.repository_details.RepositoriesDetailsFragment
import com.example.popular_libraries_training_project.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {

    fun userScreen() = FragmentScreen {
        UsersFragment()
    }

    fun userRepositories(userName: GithubUserModel) = FragmentScreen {
        RepositoriesFragment(userName)
    }

    fun repositoryDetails(
        user: GithubUserModel,
        model: GithubReposModel,
        repository: GithubReposRepository
    ) = FragmentScreen {
        RepositoriesDetailsFragment(user, model, repository)
    }
}