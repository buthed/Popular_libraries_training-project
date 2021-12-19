package com.example.popular_libraries_training_project.remote

import com.example.popular_libraries_training_project.model.GithubRepositoryModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitService {

    @GET("/users")
    fun getUsers(): Single<List<GithubUserModel>>

    @GET
    fun getRepositories(@Url repositoriesUrl: String): Single<List<GithubRepositoryModel>>

    @GET
    fun getRepository(@Url repositoryUrl: String): Single<GithubRepositoryModel>
}