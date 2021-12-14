package com.example.popular_libraries_training_project.ui.repository_details

import android.util.Log
import com.example.popular_libraries_training_project.domain.GithubReposRepository
import com.example.popular_libraries_training_project.model.GithubReposModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class RepositoriesDetailsPresenter(
    private val router: Router,
    private val githubReposModel: GithubReposModel,
): MvpPresenter<RepositoryDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

//        loadData()
        viewState.updateRepository(githubReposModel) //TODO
    }

//    private fun loadData() {
//        githubReposRepository.getRepository(githubReposModel)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .doOnSubscribe{viewState.showLoading()}
//            .subscribe(
//                { repository->
//                    viewState.updateList(repository)
//                    viewState.hideLoading()
//                },{ e->
//                    Log.e("Retrofit", "Ошибка при получении пользователей", e)
//                    viewState.hideLoading()
//                })
//    }



    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}