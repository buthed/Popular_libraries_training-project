package com.example.popular_libraries_training_project.ui.base

import com.example.popular_libraries_training_project.ui.users.UserItemView

interface IListPresenter<V: IItemView> {

    var itemClickListener: (UserItemView) -> Unit

    fun getCount(): Int

    fun bindView(view: V)
}
