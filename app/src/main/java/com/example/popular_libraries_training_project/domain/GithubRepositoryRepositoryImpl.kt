package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.cache.GithubRepositoryCache
import com.example.popular_libraries_training_project.cache.db.AppDatabase
import com.example.popular_libraries_training_project.cache.db.model.RoomGithubRepository
import com.example.popular_libraries_training_project.model.GithubRepoOwner
import com.example.popular_libraries_training_project.model.GithubRepositoryModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.remote.RetrofitService
import com.example.popular_libraries_training_project.remote.connectivity.NetworkStatus
import io.reactivex.rxjava3.core.Single

class GithubRepositoryRepositoryImpl(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val repositoryCache: GithubRepositoryCache,
) : GithubRepositoryRepository {

    override fun getRepositories(userModel: GithubUserModel): Single<List<GithubRepositoryModel>> {
        return if (networkStatus.isOnline())  {
            retrofitService.getRepositories(userModel.reposUrl)
                .flatMap(repositoryCache::insert)
        } else {
            repositoryCache.getRepository(userModel)
        }
    }

    override fun getRepository(repositoryUrl: String): Single<GithubRepositoryModel> {
        return retrofitService.getRepository(repositoryUrl)
    }
}