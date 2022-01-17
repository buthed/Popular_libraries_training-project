package com.example.popular_libraries_training_project.di.modules

import com.example.popular_libraries_training_project.App
import com.example.popular_libraries_training_project.cache.GithubRepositoryCache
import com.example.popular_libraries_training_project.cache.db.AppDatabase
import com.example.popular_libraries_training_project.di.scope.RepositoryScope
import com.example.popular_libraries_training_project.di.scope.containers.ReposScopeContainer
import com.example.popular_libraries_training_project.domain.GithubUsersRepositories
import com.example.popular_libraries_training_project.domain.GithubUsersRepositoriesImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class GithubRepoModule {

    @RepositoryScope
    @Binds
    abstract fun bindUsersRepository(impl: GithubUsersRepositoriesImpl): GithubUsersRepositories

    companion object {
        @RepositoryScope
        @Provides
        fun repoCache(db: AppDatabase): GithubRepositoryCache {
            return GithubRepositoryCache(db)
        }

        @RepositoryScope
        @Provides
        fun scopeContainer(app: App): ReposScopeContainer = app
    }
}
//OLD
//@Module
//class RepositoryModule {
//
//    @Provides
//    fun getRepositories(
//        networkStatus: NetworkStatus,
//        retrofitService: RetrofitService,
//        repositoryCache: GithubRepositoryCache,
//    ): GithubRepositoryRepository {
//        return GithubRepositoryRepositoryImpl(networkStatus, retrofitService, repositoryCache)
//    }
//
//    @Provides
//    fun getRepository(
//        networkStatus: NetworkStatus,
//        retrofitService: RetrofitService,
//        repositoryCache: GithubRepositoryCache,
//    ): GithubRepositoryRepository {
//        return GithubRepositoryRepositoryImpl(networkStatus, retrofitService, repositoryCache)
//    }
//
//
//    @Provides
//    fun getUsers(
//        networkStatus: NetworkStatus,
//        retrofitService: RetrofitService,
//        usersCache: GithubUsersRepositoriesCache,
//    ): GithubUsersRepositories {
//        return GithubUsersRepositoriesImpl(networkStatus, retrofitService, usersCache)
//    }
//}