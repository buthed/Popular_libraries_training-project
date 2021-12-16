package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.model.GithubRepositoryModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface GithubRepositoryRepository {

    fun getRepositories(reposUrl: GithubUserModel): Single<List<GithubRepositoryModel>>

    fun getRepository(reposUrl: String): Single<GithubRepositoryModel>
}