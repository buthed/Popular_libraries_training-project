package com.example.popular_libraries_training_project

class MainPresenter(
    val view: MainView
) {

    private val model = CountersModel()


    fun counterClickButton1() {
        val nextValue = model.increment(0)
        view.setButtonText1(nextValue.toString())
    }

    fun counterClickButton2() {
        val nextValue = model.increment(1)
        view.setButtonText2(nextValue.toString())
    }

    fun counterClickButton3() {
        val nextValue = model.increment(2)
        view.setButtonText3(nextValue.toString())
    }

}