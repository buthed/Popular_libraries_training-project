package com.example.popular_libraries_training_project.ui.imageloading

interface ImageLoader<T> {

    fun loadInto(url: String, container: T)
}