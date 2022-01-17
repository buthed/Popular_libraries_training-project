package com.example.popular_libraries_training_project.di.modules

import com.example.popular_libraries_training_project.App
import com.example.popular_libraries_training_project.cache.GithubUsersRepositoriesCache
import com.example.popular_libraries_training_project.cache.db.AppDatabase
import com.example.popular_libraries_training_project.di.scope.UsersScope
import com.example.popular_libraries_training_project.di.scope.containers.UsersScopeContainer
import com.example.popular_libraries_training_project.domain.GithubRepositoryRepository
import com.example.popular_libraries_training_project.domain.GithubRepositoryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class GithubUserModule {

    @UsersScope
    @Binds
    abstract fun usersRepository(impl: GithubRepositoryRepositoryImpl): GithubRepositoryRepository

    companion object {
        @UsersScope
        @Provides
        fun userCache(db: AppDatabase): GithubUsersRepositoriesCache {
            return GithubUsersRepositoriesCache(db)
        }

        @UsersScope
        @Provides
        fun scopeContainer(app: App): UsersScopeContainer = app
    }
}