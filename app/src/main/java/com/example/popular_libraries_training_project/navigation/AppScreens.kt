package com.example.popular_libraries_training_project.navigation

import com.example.popular_libraries_training_project.domain.GithubRepositoryRepository
import com.example.popular_libraries_training_project.model.GithubRepositoryModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.ui.repositories.RepositoriesFragment
import com.example.popular_libraries_training_project.ui.repository_details.RepositoryDetailsFragment
import com.example.popular_libraries_training_project.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {

    fun userScreen() = FragmentScreen {
        UsersFragment()
    }

    fun userRepositories(userModel: GithubUserModel) = FragmentScreen {
        RepositoriesFragment.newInstance(userModel)
    }

    fun repositoryDetails(
        user: GithubUserModel,
        model: GithubRepositoryModel,
        repository: GithubRepositoryRepository
    ) = FragmentScreen {
        RepositoryDetailsFragment(user, model, repository)
    }
}