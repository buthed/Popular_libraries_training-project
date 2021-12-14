package com.example.popular_libraries_training_project.remote

import com.example.popular_libraries_training_project.model.GithubReposModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitService {

    @GET("/users")
    fun getUsers(): Single<List<GithubUserModel>>

    @GET
    fun getRepos(@Url reposUrl: String): Single<List<GithubReposModel>>
}