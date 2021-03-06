package com.example.popular_libraries_training_project.ui.users

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popular_libraries_training_project.App
import com.example.popular_libraries_training_project.databinding.FragmentUsersBinding
import com.example.popular_libraries_training_project.model.GithubUserModel
import com.example.popular_libraries_training_project.remote.connectivity.NetworkStatus
import com.example.popular_libraries_training_project.ui.base.BackButtonListener
import com.example.popular_libraries_training_project.ui.imageloading.GlideImageLoader
import com.example.popular_libraries_training_project.ui.users.adapter.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private val presenter by moxyPresenter {
        App.instance.initUsersSubcomponent()
        App.instance.usersSubcomponent?.provideUsersPresenter()!!
    }

    private var _binding: FragmentUsersBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        UsersAdapter(
            presenter::onUserClicked,
            GlideImageLoader()
        )
    }

    private val status by lazy { NetworkStatus(requireContext().applicationContext) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usersRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.usersRecycler.adapter = adapter

        status.getNetworkSubject()
            .subscribe {
                Log.d("RxJava", "?????????????????? ????????: $it")
            }
    }

    override fun updateList(users: List<GithubUserModel>) {
        adapter.submitList(users)
    }

    override fun showLoading() {
        binding.loadingView.isVisible = true
        binding.usersRecycler.isVisible = false
    }

    override fun hideLoading() {
        binding.loadingView.isVisible = false
        binding.usersRecycler.isVisible = true
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }
}