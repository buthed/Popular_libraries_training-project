package com.example.popular_libraries_training_project.remote

import com.example.popular_libraries_training_project.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("/users")
    fun getUsers(): Single<List<GithubUserModel>>
}