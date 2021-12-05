package com.example.popular_libraries_training_project.ui.users

import com.example.popular_libraries_training_project.domain.GithubUsersRepository
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.screens.AppScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository
): MvpPresenter<UsersView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    fun loadData() {
        val users = usersRepository.getUsers()
        viewState.updateList(users)
    }

    fun onUserClicked(userModel: GithubUserModel) {
        router.navigateTo(AppScreens.userProfile(userModel))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}