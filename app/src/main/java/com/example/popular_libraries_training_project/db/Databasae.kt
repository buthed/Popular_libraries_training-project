package com.example.popular_libraries_training_project.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.popular_libraries_training_project.App
import com.example.popular_libraries_training_project.db.dao.RepositoryDao
import com.example.popular_libraries_training_project.db.dao.UserDao
import com.example.popular_libraries_training_project.db.model.RoomGithubRepository
import com.example.popular_libraries_training_project.db.model.RoomGithubUser

@Database(
    entities = [
        RoomGithubUser::class,
        RoomGithubRepository::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    abstract val repositoryDao: RepositoryDao

    companion object {

        private const val DB_Name = "database.db"

        val instance by lazy {
            Room.databaseBuilder(App.instance, AppDatabase::class.java, DB_Name)
                .build()
        }
    }
}