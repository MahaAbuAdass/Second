package com.example.second.ui.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.second.databinding.ViewPagerBinding
import com.example.second.ui.FirstFragment
import com.example.second.ui.Logout
import com.example.second.ui.SecondFragment
import com.google.android.material.tabs.TabLayoutMediator

class ViewPager : Fragment(){
    private lateinit var binding: ViewPagerBinding

    private val tabTitles by lazy {
        arrayOf("Login", "Register" , "Logout")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = activity?.let {
            ViewPagerAdapter(it, FirstFragment(), SecondFragment() , Logout())
        }

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()



    }

}