package com.example.popular_libraries_training_project.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.popular_libraries_training_project.db.model.RoomGithubRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface RepositoryDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(user: RoomGithubRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomGithubRepository>): Completable

    @Query("SELECT * FROM RoomGithubRepository")
    fun getAll(): Single<List<RoomGithubRepository>>

    @Query("SELECT * FROM RoomGithubRepository WHERE userId = :userId LIMIT 1")
    fun getByUserId(userId: Int): Single<List<RoomGithubRepository>>
}

