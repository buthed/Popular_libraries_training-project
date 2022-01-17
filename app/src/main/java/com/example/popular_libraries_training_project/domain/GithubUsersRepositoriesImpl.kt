package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.cache.GithubUsersRepositoriesCache
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.remote.RetrofitService
import com.example.popular_libraries_training_project.remote.connectivity.NetworkStatus
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GithubUsersRepositoriesImpl @Inject constructor(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val githubUsersRepositoriesCache: GithubUsersRepositoriesCache,
) : GithubUsersRepositories {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return if (networkStatus.isOnline()) {
            retrofitService.getUsers()
                .flatMap(githubUsersRepositoriesCache::insert)
        } else {
            githubUsersRepositoriesCache.getUsers()
        }
    }
}