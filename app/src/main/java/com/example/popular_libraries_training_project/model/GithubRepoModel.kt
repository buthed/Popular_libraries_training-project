package com.example.popular_libraries_training_project.model

import com.google.gson.annotations.Expose

data class GithubReposModel (
    @Expose
    val name: String,

    @Expose
    val forks: Int,

    @Expose
    val watchers: Int,

    @Expose
    val createdAt: String,

)
