package com.example.second.ui

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.second.R
import com.example.second.databinding.SplashScreenBinding
import com.example.second.ui.signin.SigninFragmentDirections
import com.google.gson.Gson

class SplashScreenFragment : Fragment(), OnClickListener {
    private var binding: SplashScreenBinding? = null
    private var videView: VideoView? = null

    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashScreenBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSharedPreferences()
        playvideo()
        init()
        checkLoggedinUser()
    }

    private fun playvideo() {
        val videoPath = "android.resource://${requireActivity().packageName}/${R.raw.spalsh_video}"
        val videoUri = Uri.parse(videoPath)
        binding?.videoView?.setVideoURI(videoUri)
        binding?.videoView?.setOnPreparedListener { mediaPlayer: MediaPlayer ->
            mediaPlayer.start()
            //  mediaPlayer.isLooping=true
        }

    }


    override fun onClick(v: View?) {
        when (v?.id) {
            binding?.tvLogin?.id -> {
                findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenToLogin())
            }

            binding?.tvRegister?.id -> {
                findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenToSignup())
            }
        }
    }

    fun init() {
        binding?.tvLogin?.setOnClickListener(this)
        binding?.tvRegister?.setOnClickListener(this)
    }

    fun checkLoggedinUser() {
        if (sharedPreferences?.getString(KEY_NAME, "")?.isNotEmpty() == true) {
            findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenToMenu())
        }
    }

    private fun initSharedPreferences() {
        sharedPreferences = activity?.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        );

    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.videoView?.stopPlayback()
    }

}