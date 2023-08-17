package com.example.second.ui.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.second.databinding.FromSharedPreferenceBinding
import com.example.second.ui.base_ui.BaseFragment
import com.google.gson.Gson

class FromSharedPreference : BaseFragment() {


    private lateinit var binding: FromSharedPreferenceBinding

    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FromSharedPreferenceBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun userInfoMode() = UserInfo(
        name = binding.etName.text.toString() ,
        email = binding.etEmail.text.toString() ,
        password = binding.etPassword.text.toString()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener(){
            saveUserInfo()
            findNavController().navigate(FromSharedPreferenceDirections.actionFromSharedPreFragmentToToSharedPreFragment())
        }

    }

    private fun saveUserInfo() {
        // Convert the object to a JSON string

        val gson = Gson()
        val jsonString = gson.toJson(userInfoMode())

        // Save the JSON string in SharedPreferences
        sharedPreferences = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);  // private to prevent share it  with another app

        val editor = sharedPreferences?.edit()
        editor?.putString("name", jsonString)
        editor?.apply()
    }
}


