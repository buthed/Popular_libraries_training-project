package com.example.popular_libraries_training_project.ui.repositories

import android.util.Log
import com.example.popular_libraries_training_project.domain.GithubReposRepository
import com.example.popular_libraries_training_project.model.GithubReposModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.navigation.AppScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class RepositoriesPresenter(
    private val router: Router,
    private val githubReposRepository: GithubReposRepository,
    private val githubUserModel: GithubUserModel
) : MvpPresenter<RepositoriesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        githubReposRepository.getRepositories(githubUserModel.reposUrl)
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

    fun onReposClicked(reposModel: GithubReposModel) {
        router.navigateTo(
            AppScreens.repositoryDetails(
                githubUserModel,
                reposModel,
                githubReposRepository
            )
        )
    }

    fun backPressed(): Boolean {
        router.backTo(AppScreens.userScreen())
        return true
    }
}