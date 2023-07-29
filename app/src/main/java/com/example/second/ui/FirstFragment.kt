package com.example.second.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.second.databinding.FirstFragmentBinding

class FirstFragment : Fragment (){
    private lateinit var binding : FirstFragmentBinding


    // to send data from screen to another
    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FirstFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvFirst.setOnClickListener() {
            // to send data from screen to another
            sharedPreferences = activity?.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            );  // private to prevent share it  with another app
            val editor = sharedPreferences!!.edit()
            editor.putString(KEY_NAME, "Shared prefernce message")
            editor.apply()

          //  findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())
        }
    }

}