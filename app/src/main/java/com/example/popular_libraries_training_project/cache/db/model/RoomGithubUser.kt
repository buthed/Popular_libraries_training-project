package com.example.popular_libraries_training_project.cache.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomGithubUser(
    @PrimaryKey val id: Int,
    val login: String,
    val avatarUrl: String,
    val reposUrl: String,
)