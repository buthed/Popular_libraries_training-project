package com.example.popular_libraries_training_project

import moxy.MvpPresenter


class MainPresenter(
    private val model: CountersModel
) : MvpPresenter<MainView>(){


    fun counterClickButton1() {
        val nextValue = model.increment1()
        viewState.setButtonText1(nextValue.toString())
    }

    fun counterClickButton2() {
        val nextValue = model.increment2()
        viewState.setButtonText2(nextValue.toString())
    }

    fun counterClickButton3() {
        val nextValue = model.increment3()
        viewState.setButtonText3(nextValue.toString())
    }

}