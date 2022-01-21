package com.example.popular_libraries_training_project.cache

import com.example.popular_libraries_training_project.cache.db.AppDatabase
import com.example.popular_libraries_training_project.cache.db.model.RoomGithubRepository
import com.example.popular_libraries_training_project.model.GithubRepoOwner
import com.example.popular_libraries_training_project.model.GithubRepositoryModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

class GithubRepositoryCache(
    val db: AppDatabase
) {
    fun insert(repos: List<GithubRepositoryModel>): Single<List<GithubRepositoryModel>> {
        val dbRepos = repos.map {
            RoomGithubRepository(
                it.id,
                it.name,
                it.forks,
                it.watchers,
                it.createdAt,
                it.openIssues,
                it.url,
                it.owner.id
            )
        }
        return db.repositoryDao.insert(dbRepos)
            .toSingle{ repos }
    }

    fun getRepository(userModel: GithubUserModel): Single<List<GithubRepositoryModel>> {
        return db.repositoryDao.getByUserId(userModel.id)
            .map { list->
                list.map { repo ->
                    GithubRepositoryModel(
                        repo.id,
                        repo.name,
                        repo.forks,
                        repo.watchers,
                        repo.createdAt,
                        repo.openIssues,
                        repo.url,
                        GithubRepoOwner(repo.userId)
                    ) }
            }
    }
}