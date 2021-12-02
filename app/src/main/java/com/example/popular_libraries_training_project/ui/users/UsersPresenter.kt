package com.example.popular_libraries_training_project.ui.users

import com.example.popular_libraries_training_project.domain.GithubUsersRepository
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.ui.base.IListPresenter
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val router: Router,
    private val usersRepository: GithubUsersRepository
): MvpPresenter<UsersView>(){

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()

        usersListPresenter.itemClickListener = {} //todo
    }

    fun loadData() {
        val users = usersRepository.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    class UsersListPresenter: IListPresenter<UserItemView> {

        val users = mutableListOf<GithubUserModel>()

        override var itemClickListener = { }

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }
}