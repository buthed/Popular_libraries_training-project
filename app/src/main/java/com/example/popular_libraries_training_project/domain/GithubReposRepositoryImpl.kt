package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.model.GithubReposModel
import com.example.popular_libraries_training_project.remote.RetrofitService
import io.reactivex.rxjava3.core.Single

class GithubReposRepositoryImpl(
    private  val retrofitService: RetrofitService,
): GithubReposRepository {

    override fun getRepositories(reposUrl: String): Single<List<GithubReposModel>> {
        return retrofitService.getRepositories(reposUrl)
    }

    override fun getRepository(githubReposModel: GithubReposModel): Single<GithubReposModel> {
        return retrofitService.getRepository(githubReposModel)
    }

}