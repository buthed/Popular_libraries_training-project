package com.example.popular_libraries_training_project.ui.main

import com.example.popular_libraries_training_project.navigation.AppScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val router: Router,
    private val appScreens: AppScreens,
): MvpPresenter<MainView>() {



    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.navigateTo(appScreens.userScreen())
    }

    fun backPressed() {
        router.exit()
    }
}
