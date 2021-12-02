package com.example.popular_libraries_training_project.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popular_libraries_training_project.App
import com.example.popular_libraries_training_project.databinding.FragmentUsersBinding
import com.example.popular_libraries_training_project.domain.GithubUsersRepository
import com.example.popular_libraries_training_project.ui.base.BackButtonListener
import com.example.popular_libraries_training_project.ui.users.adapter.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private val presenter by moxyPresenter { UsersPresenter(App.Companion.instance.router, GithubUsersRepository()) }

    private var _binding: FragmentUsersBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        UsersAdapter(presenter.usersListPresenter)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usersRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.usersRecycler.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }
}
