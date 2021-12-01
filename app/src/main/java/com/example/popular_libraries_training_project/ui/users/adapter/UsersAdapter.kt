package com.example.popular_libraries_training_project.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.popular_libraries_training_project.databinding.ItemUserBinding
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.ui.base.IListPresenter
import com.example.popular_libraries_training_project.ui.users.UserItemView
import com.example.popular_libraries_training_project.ui.users.UsersPresenter

class UsersAdapter(
    private val presenter: UsersPresenter.UsersListPresenter
): RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener() }
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }

    inner class UserViewHolder(val vb: ItemUserBinding): RecyclerView.ViewHolder(vb.root), UserItemView {

        override var pos: Int = -1

        override fun setLogin(login: String) {
            vb.tvLogin.text = login
        }
    }
}
