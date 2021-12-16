package com.example.popular_libraries_training_project.domain

import androidx.room.Database
import com.example.popular_libraries_training_project.db.AppDatabase
import com.example.popular_libraries_training_project.db.model.RoomGithubRepository
import com.example.popular_libraries_training_project.db.model.RoomGithubUser
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.remote.RetrofitService
import com.example.popular_libraries_training_project.remote.connectivity.NetworkStatus
import io.reactivex.rxjava3.core.Single

class GithubUsersRepositoriesImpl(
    private val networkStatus: NetworkStatus,
    private val retrofitService: RetrofitService,
    private val db: AppDatabase,
) : GithubUsersRepositories {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return if (networkStatus.isOnline()) {
            retrofitService.getUsers()
                .flatMap { users ->
                    Single.fromCallable {
                        val roomUsers = users.map { user ->
                            RoomGithubUser(user.id, user.login, user.avatarUrl, user.reposUrl)
                        }
                        db.userDao.insert(roomUsers)
                        users
                    }
                }
        } else {
            return Single.fromCallable {
                db.userDao.getAll().map { roomModel ->
                    GithubUserModel(
                        roomModel.id,
                        roomModel.login,
                        roomModel.avatarUrl,
                        roomModel.reposUrl
                    )
                }
            }
        }
    }
}