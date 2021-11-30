package com.example.popular_libraries_training_project

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle


public interface MainView: MvpView {

    @AddToEndSingle
    fun setButtonText1(text: String)

    @AddToEndSingle
    fun setButtonText2(text: String)

    @AddToEndSingle
    fun setButtonText3(text: String)

}