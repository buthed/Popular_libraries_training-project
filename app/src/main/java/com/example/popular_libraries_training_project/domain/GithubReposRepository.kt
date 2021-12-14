package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.model.GithubReposModel
import io.reactivex.rxjava3.core.Single

interface GithubReposRepository {

    fun getRepositories(reposUrl: String): Single<List<GithubReposModel>>

    fun getRepository(repositoryUrl: String): Single<GithubReposModel>
}