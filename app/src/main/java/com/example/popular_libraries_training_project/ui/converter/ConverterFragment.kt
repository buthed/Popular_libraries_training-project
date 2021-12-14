package com.example.popular_libraries_training_project.ui.converter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popular_libraries_training_project.App
import com.example.popular_libraries_training_project.R
import com.example.popular_libraries_training_project.databinding.FragmentConverterBinding
import com.example.popular_libraries_training_project.databinding.FragmentProfileBinding
import com.example.popular_libraries_training_project.domain.GithubUsersRepository
import com.example.popular_libraries_training_project.ui.users.ProfilePresenter
import com.example.popular_libraries_training_project.ui.users.UsersPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ConverterFragment : MvpAppCompatFragment() {

    private val presenter by moxyPresenter { ConverterPresenter() }

    private var _binding: FragmentConverterBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentConverterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.takeJpgFile()
    }
}