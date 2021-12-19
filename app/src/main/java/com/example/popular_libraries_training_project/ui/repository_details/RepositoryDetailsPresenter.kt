package com.example.popular_libraries_training_project.ui.repository_details

import android.util.Log
import com.example.popular_libraries_training_project.domain.GithubRepositoryRepository
import com.example.popular_libraries_training_project.model.GithubRepositoryModel
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class RepositoryDetailsPresenter(
    private val router: Router,
    private val githubRepositoryModel: GithubRepositoryModel,
    private val githubRepositoryRepository: GithubRepositoryRepository
) : MvpPresenter<RepositoryDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        githubRepositoryRepository.getRepository(githubRepositoryModel.url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.showLoading() }
            .subscribe(
                { repository ->
                    viewState.updateRepository(repository)
                    viewState.hideLoading()
                }, { e ->
                    Log.e("Retrofit", "Ошибка при получении пользователей", e)
                    viewState.hideLoading()
                })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}