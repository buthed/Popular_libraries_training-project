package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.model.GithubReposModel
import com.example.popular_libraries_training_project.remote.ApiHolder.retrofitService
import com.example.popular_libraries_training_project.remote.RetrofitService
import io.reactivex.rxjava3.core.Single

class GithubReposRepositoryImpl(
    private  val retrofitService: RetrofitService,
): GithubReposRepository {

    override fun getRepos(reposUrl: String): Single<List<GithubReposModel>> {
        return retrofitService.getRepos(reposUrl)
    }
}