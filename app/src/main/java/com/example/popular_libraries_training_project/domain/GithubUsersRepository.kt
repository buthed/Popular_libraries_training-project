package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.model.GithubUserModel
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable


class GithubUsersRepository {

    fun getUsers(): List<GithubUserModel> {
        return emptyList()
    }
}