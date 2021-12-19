package com.example.popular_libraries_training_project.model

import com.google.gson.annotations.Expose

data class GithubRepositoryModel(
    @Expose
    val id: Int,

    @Expose
    val name: String,

    @Expose
    val forks: Int,
    @Expose
    val watchers: Int,
    @Expose
    val createdAt: String,
    @Expose
    val openIssues: Int,

    @Expose
    val url: String,

    @Expose
    val owner: GithubRepoOwner,
)

data class GithubRepoOwner(
    @Expose
    val id: Int,
)