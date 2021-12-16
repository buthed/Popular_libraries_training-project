package com.example.popular_libraries_training_project.ui.repository_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.popular_libraries_training_project.App
import com.example.popular_libraries_training_project.databinding.FragmentRepositoryDetailesBinding
import com.example.popular_libraries_training_project.domain.GithubReposRepository
import com.example.popular_libraries_training_project.model.GithubReposModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.ui.base.BackButtonListener
import com.example.popular_libraries_training_project.ui.imageloading.GlideImageLoader
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepositoriesDetailsFragment(
    private val user: GithubUserModel,
    private val githubReposModel: GithubReposModel,
    private val githubReposRepository: GithubReposRepository,
) : MvpAppCompatFragment(), RepositoryDetailsView, BackButtonListener {

    private val presenter by moxyPresenter {
        RepositoriesDetailsPresenter(
            App.instance.router,
            githubReposModel,
            githubReposRepository
        )
    }

    private val imageloader by lazy { GlideImageLoader() }
    private var _binding: FragmentRepositoryDetailesBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        binding.repositoryForks.text = "Forks:" + repository.forks.toString()
        binding.repositoryWatchers.text = "Watchers: " + repository.watchers.toString()
        binding.repositoryIssues.text = "Open Issues:" + repository.openIssues.toString()
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