package com.example.second.ui.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.second.databinding.FromSharedPreferenceBinding
import com.example.second.databinding.ToSharedPreferenceBinding
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class ToSharedPrefernce : Fragment() {
    private lateinit var binding: ToSharedPreferenceBinding

    // send data from screen to another
    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ToSharedPreferenceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val jsonString = sharedPreferences?.getString(KEY_NAME, null)
        val gson = Gson()
        jsonString?.let { gson.fromJson(it, UserInfo::class.java) }?.let {
            binding.tvName.text = "My Name : ${it.name}"
            binding.tvEmail.text = "Email : ${it.email}"
            binding.tvPassword.text = "National ID: ${(it.password)}"

        }
    }
}