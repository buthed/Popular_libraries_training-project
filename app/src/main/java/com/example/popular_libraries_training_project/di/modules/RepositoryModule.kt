package com.example.popular_libraries_training_project.di.modules

import com.example.popular_libraries_training_project.db.AppDatabase
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
        db: AppDatabase,
    ): GithubRepositoryRepository {
        return GithubRepositoryRepositoryImpl(networkStatus, retrofitService, db)
    }

    @Provides
    fun getRepository(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        db: AppDatabase,
    ): GithubRepositoryRepository {
        return GithubRepositoryRepositoryImpl(networkStatus, retrofitService, db)
    }


    @Provides
    fun getUsers(
        networkStatus: NetworkStatus,
        retrofitService: RetrofitService,
        db: AppDatabase,
    ): GithubUsersRepositories {
        return GithubUsersRepositoriesImpl(networkStatus, retrofitService, db)
    }
}