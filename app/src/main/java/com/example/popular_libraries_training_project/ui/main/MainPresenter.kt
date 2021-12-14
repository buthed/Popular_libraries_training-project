package com.example.popular_libraries_training_project.ui.main

import com.example.popular_libraries_training_project.screens.AppScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.navigateTo(AppScreens.photoConverter())
    }

    fun backPressed() {
        router.exit()
    }
}