package com.iiinaiii.uisamples.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.iiinaiii.uisamples.R
import com.iiinaiii.uisamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupToolbar()
    }

    private fun setupToolbar() {
        val navController = findNavController(R.id.nav_host_fragment)
        val toolbar = binding.toolbar
        toolbar.setupWithNavController(navController)
    }
}
