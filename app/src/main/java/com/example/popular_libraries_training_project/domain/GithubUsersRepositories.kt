package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubUsersRepositories {

    fun getUsers(): Single<List<GithubUserModel>>
}