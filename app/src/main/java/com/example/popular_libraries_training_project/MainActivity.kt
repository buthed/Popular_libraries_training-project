package com.example.popular_libraries_training_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.popular_libraries_training_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private  var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCounter1.setOnClickListener { presenter.counterClickButton1() }
        binding.btnCounter2.setOnClickListener { presenter.counterClickButton2() }
        binding.btnCounter3.setOnClickListener { presenter.counterClickButton3() }
    }

    override fun setButtonText1(text: String) {
        binding.btnCounter1.text = text
    }

    override fun setButtonText2(text: String) {
        binding.btnCounter2.text = text
    }

    override fun setButtonText3(text: String) {
        binding.btnCounter3.text = text
    }
}
