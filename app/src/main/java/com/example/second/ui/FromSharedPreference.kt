package com.example.second.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.second.databinding.FromSharedPreferenceBinding

class FromSharedPreference : Fragment() {
    private lateinit var binding: FromSharedPreferenceBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FromSharedPreferenceBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvFromSharedPre.setOnClickListener{
            findNavController().navigate()
        }
    }
}


