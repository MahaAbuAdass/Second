package com.example.second.ui.base_ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.second.R
import com.example.second.databinding.ActivityMainBinding
import com.example.second.ui.dashboard.DashboardFragment
import com.example.second.ui.home.HomeFragment
import com.example.second.ui.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

open class BaseActivity : AppCompatActivity() {
    var mainBinding: ActivityMainBinding? = null
    lateinit var navController: NavController
    protected lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)
        navView = mainBinding?.navView!!
        navController = findNavController(R.id.nav_host_fragment_activity_main)
        mainBinding?.toolbar?.backToolbar?.setOnClickListener {
            onBackPressed()
        }
    }


    private fun getCurrentFragment() =
        supportFragmentManager.fragments[0].childFragmentManager.fragments[0]

    fun isMainFragments() =
        getCurrentFragment() is NotificationsFragment || getCurrentFragment() is DashboardFragment || getCurrentFragment() is HomeFragment

    override fun onBackPressed() {
        if (isMainFragments()) moveTaskToBack(true)
        else onBackPressedDispatcher.onBackPressed()
    }

}