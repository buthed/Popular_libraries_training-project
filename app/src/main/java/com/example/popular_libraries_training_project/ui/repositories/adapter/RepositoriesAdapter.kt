package com.example.popular_libraries_training_project.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.popular_libraries_training_project.databinding.ItemReposBinding
import com.example.popular_libraries_training_project.model.GithubRepositoryModel

class ReposAdapter(
    private val itemClickListener: (GithubRepositoryModel) -> Unit,
) : ListAdapter<GithubRepositoryModel, ReposAdapter.ReposViewHolder>(GithubReposItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        return ReposViewHolder(
            ItemReposBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ReposAdapter.ReposViewHolder, position: Int) {
        holder.showRepos(currentList[position])
    }

    inner class ReposViewHolder(private val vb: ItemReposBinding) :
        RecyclerView.ViewHolder(vb.root) {

        fun showRepos(repository: GithubRepositoryModel) {
            vb.root.setOnClickListener { itemClickListener(repository) }
            vb.reposName.text = repository.name
            vb.reposCreated.text = repository.createdAt
        }
    }
}

object GithubReposItemCallback : DiffUtil.ItemCallback<GithubRepositoryModel>() {

    override fun areItemsTheSame(
        oldItem: GithubRepositoryModel,
        newItem: GithubRepositoryModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: GithubRepositoryModel,
        newItem: GithubRepositoryModel
    ): Boolean {
        return oldItem == newItem
    }
}