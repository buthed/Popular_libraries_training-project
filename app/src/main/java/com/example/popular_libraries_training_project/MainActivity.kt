package com.example.popular_libraries_training_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.popular_libraries_training_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}