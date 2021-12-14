package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.model.GithubReposModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Url

interface GithubReposRepository {

    fun getRepositories(reposUrl: String): Single<List<GithubReposModel>>

    fun getRepository(@Url repositoryUrl: String): Single<GithubReposModel>
}

