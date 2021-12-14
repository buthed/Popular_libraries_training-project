package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.model.GithubReposModel
import com.example.popular_libraries_training_project.remote.RetrofitService
import io.reactivex.rxjava3.core.Single

class GithubReposRepositoryImpl(
    private  val retrofitService: RetrofitService,
): GithubReposRepository {

    override fun getRepositories(repositoriesUrl: String): Single<List<GithubReposModel>> {
        return retrofitService.getRepositories(repositoriesUrl)
    }

    override fun getRepository(repositoryUrl: String): Single<GithubReposModel> {
        return retrofitService.getRepository(repositoryUrl)
    }

}