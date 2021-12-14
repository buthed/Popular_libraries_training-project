package com.example.popular_libraries_training_project.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.popular_libraries_training_project.databinding.ItemReposBinding
import com.example.popular_libraries_training_project.databinding.ItemUserBinding
import com.example.popular_libraries_training_project.model.GithubReposModel
import com.example.popular_libraries_training_project.model.GithubUserModel


class ReposAdapter(
    private val itemClickListener: (GithubReposModel) -> Unit,
): ListAdapter<GithubReposModel, ReposAdapter.ReposViewHolder>(GithubReposItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        return ReposViewHolder(
            ItemReposBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ReposAdapter.ReposViewHolder, position: Int) {
        holder.showRepos(currentList[position])
    }

    inner class ReposViewHolder(private val vb: ItemReposBinding) : RecyclerView.ViewHolder(vb.root) {

        fun showRepos(repos: GithubReposModel) {
            vb.root.setOnClickListener { itemClickListener(repos) }
            vb.reposName.text = repos.name
        }
    }
}

object GithubReposItemCallback : DiffUtil.ItemCallback<GithubReposModel>() {

    override fun areItemsTheSame(oldItem: GithubReposModel, newItem: GithubReposModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GithubReposModel, newItem: GithubReposModel): Boolean {
        return oldItem == newItem
    }
}