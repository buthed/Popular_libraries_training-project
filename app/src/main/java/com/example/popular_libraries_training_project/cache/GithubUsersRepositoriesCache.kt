package com.example.popular_libraries_training_project.cache

import com.example.popular_libraries_training_project.cache.db.AppDatabase
import com.example.popular_libraries_training_project.cache.db.model.RoomGithubUser
import com.example.popular_libraries_training_project.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

class GithubUsersRepositoriesCache(
    val db: AppDatabase
) {
    fun insert(users: List<GithubUserModel>): Single<List<GithubUserModel>> {
        val roomUsers = users.map { user ->
            RoomGithubUser(user.id, user.login, user.avatarUrl, user.reposUrl)
        }
        return db.userDao.insert(roomUsers)
            .toSingle{ users }

    }

    fun getUsers(): Single<List<GithubUserModel>> {
        return db.userDao.getAll().map { users ->
            users.map { roomModel ->
                GithubUserModel(roomModel.id, roomModel.login, roomModel.avatarUrl, roomModel.reposUrl)
            }
        }
    }
}