package com.example.popular_libraries_training_project.ui.users

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface UsersView: MvpView {

    @AddToEndSingle
    fun updateList()
}