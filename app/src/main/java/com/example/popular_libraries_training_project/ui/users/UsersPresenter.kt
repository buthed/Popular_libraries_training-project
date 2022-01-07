package com.example.popular_libraries_training_project.ui.users

import android.util.Log
import com.example.popular_libraries_training_project.domain.GithubUsersRepositories
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.navigation.AppScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UsersPresenter(): MvpPresenter<UsersView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var usersRepositories: GithubUsersRepositories

    @Inject
    lateinit var appScreens: AppScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        usersRepositories.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.showLoading() }
            .subscribe(
                { users ->
                    viewState.updateList(users)
                    viewState.hideLoading()
                }, { e ->
                    Log.e("Retrofit", "Ошибка при получении пользователей", e)
                    viewState.hideLoading()
                })
    }

    fun onUserClicked(userModel: GithubUserModel) {
        router.navigateTo(appScreens.userRepositories(userModel))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}