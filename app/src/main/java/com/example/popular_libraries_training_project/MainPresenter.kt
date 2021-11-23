package com.example.popular_libraries_training_project

import androidx.annotation.IdRes

class MainPresenter(
    val view: MainView
) {

    private val model = CountersModel()

    fun counterClick(@IdRes id: Int) { //TODO Arch mistake
        when(id) {
            R.id.btn_counter1 -> {
                val nextValue = model.increment(0)
                view.setButtonText(0, nextValue.toString())
            }
            R.id.btn_counter2 -> {
                val nextValue = model.increment(1)
                view.setButtonText(1, nextValue.toString())
            }
            R.id.btn_counter3 -> {
                val nextValue = model.increment(2)
                view.setButtonText(2, nextValue.toString())
            }
        }
    }

}