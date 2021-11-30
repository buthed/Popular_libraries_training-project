package com.example.popular_libraries_training_project

class MainPresenter(
    val view: MainView
) {

    private val model = CountersModel()


    fun counterClickButton1() {
        val nextValue = model.increment1()
        view.setButtonText1(nextValue.toString())
    }

    fun counterClickButton2() {
        val nextValue = model.increment2()
        view.setButtonText2(nextValue.toString())
    }

    fun counterClickButton3() {
        val nextValue = model.increment3()
        view.setButtonText3(nextValue.toString())
    }

}