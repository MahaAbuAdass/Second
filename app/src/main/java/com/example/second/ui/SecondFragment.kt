package com.example.second.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.second.databinding.SecondFragmentBinding
import com.example.second.ui.base_ui.BaseFragment

class SecondFragment : BaseFragment() {
    private lateinit var binding: SecondFragmentBinding

    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val message = sharedPreferences?.getString(KEY_NAME, "");
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()


        binding.tvSecond.setOnClickListener(){
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToRecyclerView())
        }
    }
}

