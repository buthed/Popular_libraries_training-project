package com.example.popular_libraries_training_project.ui.repositories

import com.example.popular_libraries_training_project.model.GithubReposModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface RepositoriesView : MvpView {

    @AddToEndSingle
    fun updateList(repositories: List<GithubReposModel>)

    @AddToEndSingle
    fun showLoading()

    @AddToEndSingle
    fun hideLoading()
}