package com.example.second.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.second.databinding.MenuFragmentBinding

class MenuFragment : Fragment(), OnClickListener {
    private var binding: MenuFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MenuFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiate()
    }

    private fun initiate() {
        binding?.tvPrivacyPolicy?.setOnClickListener(this)
        binding?.tvAboutUs?.setOnClickListener(this)
        binding?.tvAddress?.setOnClickListener(this)
        binding?.tvOrder?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding?.tvPrivacyPolicy?.id -> {
                findNavController().navigate(MenuFragmentDirections.actionMenuToWebView("http://www.alesayidistribution.com/mobilehtml/privacy.html"))
            }
            binding?.tvAboutUs?.id -> {
                findNavController().navigate(MenuFragmentDirections.actionMenuToWebView("http://www.alesayidistribution.com/mobilehtml/about.html"))
            }
            binding?.tvAddress?.id -> {
                findNavController().navigate(MenuFragmentDirections.actionMenuToAddress())
            }
            binding?.tvOrder?.id -> {
                findNavController().navigate(MenuFragmentDirections.actionMenuToOrders())
            }
        }
    }

}



