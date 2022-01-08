package com.example.popular_libraries_training_project.ui.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popular_libraries_training_project.App
import com.example.popular_libraries_training_project.databinding.FragmentRepositoriesBinding
import com.example.popular_libraries_training_project.db.AppDatabase
import com.example.popular_libraries_training_project.domain.GithubRepositoryRepositoryImpl
import com.example.popular_libraries_training_project.model.GithubRepositoryModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.remote.ApiHolder
import com.example.popular_libraries_training_project.remote.connectivity.NetworkStatus
import com.example.popular_libraries_training_project.ui.base.BackButtonListener
import com.example.popular_libraries_training_project.ui.imageloading.GlideImageLoader
import com.example.popular_libraries_training_project.ui.users.adapter.ReposAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepositoriesFragment : MvpAppCompatFragment(), RepositoriesView, BackButtonListener {

    private val presenter by moxyPresenter {
        App.instance.appComponent.repositoriesPresenterFactory().presenter(userModel, GithubRepositoryRepositoryImpl(
            networkStatus = NetworkStatus(requireContext()),
            retrofitService = ApiHolder.retrofitService,
            db = AppDatabase.instance,
        ))
    }

    private val imageloader by lazy { GlideImageLoader() }
    private var _binding: FragmentRepositoriesBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        ReposAdapter(
            presenter::onReposClicked,
        )
    }

    private val userModel: GithubUserModel by lazy {
        requireArguments().getSerializable(KEY_USER_MODEL) as GithubUserModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reposRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.reposRecycler.adapter = adapter

        binding.userLogin.text = userModel.login
        imageloader.loadInto(userModel.avatarUrl, binding.userImage)
    }

    override fun updateList(repos: List<GithubRepositoryModel>) {
        adapter.submitList(repos)
    }

    override fun showLoading() {
        binding.loadingViewRepositories.isVisible = true
        binding.reposRecycler.isVisible = false
    }

    override fun hideLoading() {
        binding.loadingViewRepositories.isVisible = false
        binding.reposRecycler.isVisible = true
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    companion object {

        private const val KEY_USER_MODEL = "KEY_USER_MODEL"

        fun newInstance(userModel: GithubUserModel): RepositoriesFragment {
            return RepositoriesFragment().apply {
                arguments = bundleOf(KEY_USER_MODEL to userModel)
            }
        }
    }
}