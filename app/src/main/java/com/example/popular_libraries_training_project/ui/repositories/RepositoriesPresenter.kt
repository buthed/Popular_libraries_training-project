package com.example.popular_libraries_training_project.ui.repositories

import android.util.Log
import com.example.popular_libraries_training_project.domain.GithubRepositoryRepository
import com.example.popular_libraries_training_project.model.GithubRepositoryModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.navigation.AppScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class RepositoriesPresenter(
    private val githubUserModel: GithubUserModel,
    private val githubRepositoryRepository: GithubRepositoryRepository
): MvpPresenter<RepositoriesView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var appScreens: AppScreens


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        githubRepositoryRepository.getRepositories(githubUserModel)
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

    fun onReposClicked(repositoryModel: GithubRepositoryModel) {
        router.navigateTo(
            appScreens.repositoryDetails(
                githubUserModel,
                repositoryModel,
                githubRepositoryRepository
            )
        )
    }

    fun backPressed(): Boolean {
        router.backTo(appScreens.userScreen())
        return true
    }
}