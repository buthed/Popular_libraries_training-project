package com.example.popular_libraries_training_project.domain

import com.example.popular_libraries_training_project.db.AppDatabase
import com.example.popular_libraries_training_project.db.model.RoomGithubRepository
import com.example.popular_libraries_training_project.db.model.RoomGithubUser
import com.example.popular_libraries_training_project.model.GithubRepoOwner
import com.example.popular_libraries_training_project.model.GithubRepositoryModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.remote.RetrofitService
import com.example.popular_libraries_training_project.remote.connectivity.NetworkStatus
import io.reactivex.rxjava3.core.Single

class GithubRepositoryRepositoryImpl(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val db: AppDatabase,
) : GithubRepositoryRepository {

    override fun getRepositories(userModel: GithubUserModel): Single<List<GithubRepositoryModel>> {
        return if (networkStatus.isOnline())  {
            retrofitService.getRepositories(userModel.reposUrl)
                .flatMap { repos ->
                    Single.fromCallable {
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
                        db.repositoryDao.insert(dbRepos)
                        repos
                    }
                }
        } else {
            Single.fromCallable {
                db.repositoryDao.getByUserId(userModel.id)
                    .map {
                        GithubRepositoryModel(
                            it.id,
                            it.name,
                            it.forks,
                            it.watchers,
                            it.createdAt,
                            it.openIssues,
                            it.url,
                            GithubRepoOwner(it.userId)
                        )
                    }
            }
        }
    }

    override fun getRepository(repositoryUrl: String): Single<GithubRepositoryModel> {
        return retrofitService.getRepository(repositoryUrl)
    }
}