package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.model.GithubUserModel

class GithubUsersRepository {

    private val users = listOf(
        GithubUserModel("user1"),
        GithubUserModel("user2"),
        GithubUserModel("user3"),
        GithubUserModel("user4"),
        GithubUserModel("user5"),
        GithubUserModel("user6")
    )

    fun getUsers(): List<GithubUserModel> {
        return users
    }
}