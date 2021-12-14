package com.example.popular_libraries_training_project.ui.repository_details

import com.example.popular_libraries_training_project.model.GithubReposModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface RepositoryDetailsView: MvpView {

    @AddToEndSingle
    fun updateRepository(repository: GithubReposModel)

    @AddToEndSingle
    fun showLoading()

    @AddToEndSingle
    fun hideLoading()
}