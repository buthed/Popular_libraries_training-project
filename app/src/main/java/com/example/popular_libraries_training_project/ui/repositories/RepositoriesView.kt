package com.example.popular_libraries_training_project.ui.repositories

import com.example.popular_libraries_training_project.model.GithubRepositoryModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface RepositoriesView : MvpView {

    @AddToEndSingle
    fun updateList(repositories: List<GithubRepositoryModel>)

    @AddToEndSingle
    fun showLoading()

    @AddToEndSingle
    fun hideLoading()
}