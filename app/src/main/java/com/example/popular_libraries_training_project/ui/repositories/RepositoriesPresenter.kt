package com.example.popular_libraries_training_project.ui.repositories

import android.util.Log
import com.example.popular_libraries_training_project.di.scope.containers.ReposScopeContainer
import com.example.popular_libraries_training_project.domain.GithubRepositoryRepository
import com.example.popular_libraries_training_project.model.GithubRepositoryModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.navigation.AppScreens
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class RepositoriesPresenter @AssistedInject constructor(
    private val router: Router,
    private val appScreens: AppScreens,
    private val reposScopeContainer: ReposScopeContainer,
    @Assisted private val githubUserModel: GithubUserModel,
    @Assisted private val githubRepositoryRepository: GithubRepositoryRepository
): MvpPresenter<RepositoriesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    override fun onDestroy() {
        reposScopeContainer.destroyRepoSubcomponent()
        super.onDestroy()
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

@AssistedFactory
interface RepositoriesPresenterFactory {

    fun presenter(githubUserModel: GithubUserModel, githubRepositoryRepository: GithubRepositoryRepository): RepositoriesPresenter
}