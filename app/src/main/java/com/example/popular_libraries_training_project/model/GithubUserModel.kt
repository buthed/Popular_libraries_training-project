package com.example.popular_libraries_training_project.model

import com.google.gson.annotations.Expose

data class GithubUserModel(
    @Expose
    val login: String,

    @Expose
    val avatarUrl: String,
)
