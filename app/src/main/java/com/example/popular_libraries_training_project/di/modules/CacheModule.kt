package com.example.popular_libraries_training_project.di.modules

import android.content.Context
import androidx.room.Room
import com.example.popular_libraries_training_project.db.AppDatabase
import dagger.Module
import dagger.Provides

private const val DB_Name = "database.db"

@Module
class CacheModule {

    @Provides
    fun db(context: Context): AppDatabase = Room
        .databaseBuilder(context, AppDatabase::class.java, DB_Name)
        .build()
}