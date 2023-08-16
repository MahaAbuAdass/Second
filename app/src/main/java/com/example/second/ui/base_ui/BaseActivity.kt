package com.example.second.ui.base_ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.second.R
import com.example.second.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

open class BaseActivity: AppCompatActivity() {
    var mainBinding: ActivityMainBinding? = null
    lateinit var navController: NavController

    protected lateinit var navView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

  mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding?.navView)
        navController = findNavController(R.id.nav_host_fragment_activity_main)
        mainBinding?.toolbar?.backToolbar?.setOnClickListener{
            onBackPressed()
        }

    }
}