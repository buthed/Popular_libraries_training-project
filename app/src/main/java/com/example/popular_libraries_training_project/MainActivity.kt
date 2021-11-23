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

        val listner = View.OnClickListener { view ->
            presenter.counterClick(view.id)
        }

        binding.btnCounter1.setOnClickListener(listner)
        binding.btnCounter2.setOnClickListener(listner)
        binding.btnCounter3.setOnClickListener(listner)
    }

    override fun setButtonText(index: Int, text: String) = when(index) { //TODO Homework
        0 -> binding.btnCounter1.text = text
        1 -> binding.btnCounter2.text = text
        2 -> binding.btnCounter3.text = text
        else -> error("Неверный индекс")
    }
}
