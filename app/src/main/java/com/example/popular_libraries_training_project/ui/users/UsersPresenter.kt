package com.example.popular_libraries_training_project.ui.users

import android.util.Log
import com.example.popular_libraries_training_project.domain.GithubUsersRepository
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.remote.ApiHolder
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository
): MvpPresenter<UsersView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        usersRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ users->
                       viewState.updateList(users)
            },{ e->
                Log.e("Retrofit", "Ошибка при получении пользователей", e)
            })
    }

    fun onUserClicked(userModel: GithubUserModel) {
      //  router.navigateTo(AppScreens.userProfile(userModel))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}