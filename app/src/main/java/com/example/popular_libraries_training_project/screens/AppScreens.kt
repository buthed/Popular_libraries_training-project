package com.example.popular_libraries_training_project.screens

import com.example.popular_libraries_training_project.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {

    fun userScreen() = FragmentScreen {
        UsersFragment()
    }
}