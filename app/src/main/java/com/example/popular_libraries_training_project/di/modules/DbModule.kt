package com.example.popular_libraries_training_project.di.modules

import android.content.Context
import androidx.room.Room
import com.example.popular_libraries_training_project.cache.GithubUsersRepositoriesCache
import com.example.popular_libraries_training_project.cache.GithubRepositoryCache
import com.example.popular_libraries_training_project.cache.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DB_Name = "database.db"

@Module
class DbModule {

    @Singleton
    @Provides
    fun db(context: Context): AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, DB_Name)
        .build()

    @Singleton
    @Provides
    fun repositoryCache(
        db: AppDatabase
    ): GithubRepositoryCache{
        return GithubRepositoryCache(db)
    }


}