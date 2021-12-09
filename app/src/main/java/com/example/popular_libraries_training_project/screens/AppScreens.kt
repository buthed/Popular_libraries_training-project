package com.example.popular_libraries_training_project.screens

import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.ui.converter.ConverterFragment
import com.example.popular_libraries_training_project.ui.users.ProfileFragment
import com.example.popular_libraries_training_project.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {

    fun userScreen() = FragmentScreen {
        UsersFragment()
    }

    fun userProfile(userName: GithubUserModel) = FragmentScreen {
        ProfileFragment(userName)
    }

    fun photoConverter() = FragmentScreen {
        ConverterFragment()
    }
}