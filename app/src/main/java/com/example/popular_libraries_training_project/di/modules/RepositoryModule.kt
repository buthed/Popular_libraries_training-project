package com.example.popular_libraries_training_project.di.modules

import com.example.popular_libraries_training_project.GithubUsersRepositoriesCache
import com.example.popular_libraries_training_project.cache.GithubRepositoryCache
import com.example.popular_libraries_training_project.cache.db.AppDatabase
import com.example.popular_libraries_training_project.domain.GithubRepositoryRepository
import com.example.popular_libraries_training_project.domain.GithubRepositoryRepositoryImpl
import com.example.popular_libraries_training_project.domain.GithubUsersRepositories
import com.example.popular_libraries_training_project.domain.GithubUsersRepositoriesImpl
import com.example.popular_libraries_training_project.remote.RetrofitService
import com.example.popular_libraries_training_project.remote.connectivity.NetworkStatus
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun getRepositories(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        repositoryCache: GithubRepositoryCache,
    ): GithubRepositoryRepository {
        return GithubRepositoryRepositoryImpl(networkStatus, retrofitService, repositoryCache)
    }

    @Provides
    fun getRepository(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        repositoryCache: GithubRepositoryCache,
    ): GithubRepositoryRepository {
        return GithubRepositoryRepositoryImpl(networkStatus, retrofitService, repositoryCache)
    }


    @Provides
    fun getUsers(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        usersCache: GithubUsersRepositoriesCache,
    ): GithubUsersRepositories {
        return GithubUsersRepositoriesImpl(networkStatus, retrofitService, usersCache)
    }
}