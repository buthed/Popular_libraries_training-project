package com.example.popular_libraries_training_project.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popular_libraries_training_project.App
import com.example.popular_libraries_training_project.databinding.FragmentProfileBinding
import com.example.popular_libraries_training_project.model.GithubUserModel
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ProfileFragment(private val user: GithubUserModel) : MvpAppCompatFragment(), ProfileView{

    private val presenter by moxyPresenter { ProfilePresenter(App.Companion.instance.router) }

    private var _binding: FragmentProfileBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.userName.text = user.login
    }
}