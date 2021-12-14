package com.example.popular_libraries_training_project.ui.repository_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popular_libraries_training_project.App
import com.example.popular_libraries_training_project.databinding.FragmentRepositoriesBinding
import com.example.popular_libraries_training_project.databinding.FragmentRepositoryDetailesBinding
import com.example.popular_libraries_training_project.domain.GithubReposRepositoryImpl
import com.example.popular_libraries_training_project.model.GithubReposModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.remote.ApiHolder
import com.example.popular_libraries_training_project.ui.base.BackButtonListener
import com.example.popular_libraries_training_project.ui.imageloading.GlideImageLoader
import com.example.popular_libraries_training_project.ui.repositories.RepositoriesPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepositoriesDetailsFragment(
    private val user: GithubUserModel,
    private val githubReposModel: GithubReposModel,
): MvpAppCompatFragment(), RepositoryDetailsView, BackButtonListener {

    private val presenter by moxyPresenter {
        RepositoriesDetailsPresenter(
            App.instance.router,
            githubReposModel,
        )
    }

    private val imageloader by lazy { GlideImageLoader() }
    private var _binding: FragmentRepositoryDetailesBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRepositoryDetailesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.userLogin.text = user.login
        imageloader.loadInto(user.avatarUrl, binding.userImage)
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    override fun updateRepository(repository: GithubReposModel) {
        binding.repositoryName.text = repository.name
    }

    override fun showLoading() {
        binding.loadingViewRepositoryDetails.isVisible = true
        binding.repositoryName.isVisible = false //TODO
    }

    override fun hideLoading() {
        binding.loadingViewRepositoryDetails.isVisible = false
        binding.repositoryName.isVisible = true
    }
}