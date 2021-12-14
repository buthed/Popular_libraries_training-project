package com.example.popular_libraries_training_project.ui.users

import com.example.popular_libraries_training_project.model.GithubReposModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ProfileView : MvpView {

    @AddToEndSingle
    fun updateList(reposes: List<GithubReposModel>)

    @AddToEndSingle
    fun showLoading()

    @AddToEndSingle
    fun hideLoading()
}