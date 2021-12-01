package com.example.popular_libraries_training_project.ui.users

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popular_libraries_training_project.databinding.ActivityMainBinding
import com.example.popular_libraries_training_project.domain.GithubUsersRepository
import com.example.popular_libraries_training_project.ui.users.adapter.UsersAdapter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class UsersActivity : MvpAppCompatActivity(), UsersView {

    private val presenter by moxyPresenter { UsersPresenter(GithubUsersRepository()) }

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        UsersAdapter(presenter.usersListPresenter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usersRecycler.layoutManager = LinearLayoutManager(this)
        binding.usersRecycler.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }
}
