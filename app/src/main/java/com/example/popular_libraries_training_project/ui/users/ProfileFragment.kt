package com.example.popular_libraries_training_project.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popular_libraries_training_project.App
import com.example.popular_libraries_training_project.databinding.FragmentProfileBinding
import com.example.popular_libraries_training_project.domain.GithubReposRepositoryImpl
import com.example.popular_libraries_training_project.domain.GithubUsersRepositoryImpl
import com.example.popular_libraries_training_project.model.GithubReposModel
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.remote.ApiHolder
import com.example.popular_libraries_training_project.ui.base.BackButtonListener
import com.example.popular_libraries_training_project.ui.users.adapter.ReposAdapter
import com.example.popular_libraries_training_project.ui.users.adapter.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ProfileFragment(
    private val user: GithubUserModel
    ) : MvpAppCompatFragment(), ProfileView, BackButtonListener {

    private val presenter by moxyPresenter { ProfilePresenter(
        App.instance.router,
        GithubReposRepositoryImpl(ApiHolder.retrofitService),
        user
    ) }

    private var _binding: FragmentProfileBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        ReposAdapter(
            presenter::onReposClicked,
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.reposRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.reposRecycler.adapter = adapter
    }

    override fun updateList(repos: List<GithubReposModel>) {
        adapter.submitList(repos)
    }

    override fun showLoading() {
        binding.loadingViewRepos.isVisible = true
        binding.userName.isVisible = false
    }

    override fun hideLoading() {
        binding.loadingViewRepos.isVisible = false
        binding.userName.isVisible = true
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }
}