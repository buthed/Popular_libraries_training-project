package com.example.popular_libraries_training_project.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = RoomGithubUser::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RoomGithubRepository(
    @PrimaryKey val id: Int,
    val name: String,
    val forks: Int,
    val watchers: Int,
    val createdAt: String,
    val openIssues: Int,
    val url: String,
    val userId: Int,
)

