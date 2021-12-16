package com.example.popular_libraries_training_project.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.popular_libraries_training_project.db.model.RoomGithubRepository

@Dao
interface RepositoryDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(user: RoomGithubRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomGithubRepository>)

    @Query("SELECT * FROM RoomGithubRepository")
    fun getAll(): List<RoomGithubRepository>

    @Query("SELECT * FROM RoomGithubRepository WHERE userId = :userId LIMIT 1")
    fun getByUserId(userId: Int): List<RoomGithubRepository>
}


