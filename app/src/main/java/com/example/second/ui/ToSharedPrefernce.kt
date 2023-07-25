package com.example.second.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.second.databinding.FromSharedPreferenceBinding
import com.example.second.databinding.ToSharedPreferenceBinding

class ToSharedPrefernce : Fragment() {
    private lateinit var binding: ToSharedPreferenceBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ToSharedPreferenceBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}