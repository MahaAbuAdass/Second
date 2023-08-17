package com.example.second.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.second.databinding.BottomSheetBinding
import com.example.second.databinding.MenuFragmentBinding
import com.example.second.generic.GeneralBottomSheetDialog
import com.example.second.ui.base_ui.BaseFragment
import com.example.second.ui.logout.LogoutRequestModel
import com.example.second.ui.logout.LogoutViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class MenuFragment(activity: FragmentActivity) : BaseFragment(), OnClickListener {
    private var binding: MenuFragmentBinding? = null
    private var logouViewModel : LogoutViewModel?=null
    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null
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
        initiatSharedPreference()
        observerViewModel()
    }

    private fun initiatSharedPreference() {
        sharedPreferences = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    private fun observerViewModel() {
        logouViewModel = ViewModelProvider(this)[LogoutViewModel::class.java]

        logouViewModel?.logoutResponse?.observe(viewLifecycleOwner){
            CoroutineScope(Dispatchers.Main).launch {
                sharedPreferences?.edit()?.remove(KEY_NAME)?.apply()
                findNavController().navigate(MenuFragmentDirections.actionMenuToSplashScreen())
            }
        }
        logouViewModel?.logoutResponseError?.observe(viewLifecycleOwner){
            CoroutineScope(Dispatchers.Main).launch {
                Toast.makeText(activity,it.toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun callLogout(){
        CoroutineScope(Dispatchers.IO).launch {
            logouViewModel?.logoutUser(
                logoutRequestModel(), sharedPreferences?.getString(KEY_NAME, "") ?: ""
            )
        }
    }
    private fun logoutRequestModel() = LogoutRequestModel("")

    private fun initiate() {
        binding?.tvPrivacyPolicy?.setOnClickListener(this)
        binding?.tvAboutUs?.setOnClickListener(this)
        binding?.tvAddress?.setOnClickListener(this)
        binding?.tvOrder?.setOnClickListener(this)
        binding?.tvProduct?.setOnClickListener(this)
        binding?.tvLogout?.setOnClickListener(this)
        binding?.tvProfile?.setOnClickListener(this)
        binding?.tvBottomSheet?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding?.tvPrivacyPolicy?.id -> findNavController().navigate(MenuFragmentDirections.actionMenuToWebView("http://www.alesayidistribution.com/mobilehtml/privacy.html"))
            binding?.tvAboutUs?.id ->  findNavController().navigate(MenuFragmentDirections.actionMenuToWebView("http://www.alesayidistribution.com/mobilehtml/about.html"))
            binding?.tvAddress?.id ->  findNavController().navigate(MenuFragmentDirections.actionMenuToAddress())
            binding?.tvOrder?.id -> findNavController().navigate(MenuFragmentDirections.actionMenuToOrders())
            binding?.tvProduct?.id ->  findNavController().navigate(MenuFragmentDirections.actionMenuToProduct())
            binding?.tvLogout?.id -> callLogout()
            binding?.tvProfile?.id -> findNavController().navigate(MenuFragmentDirections.actionMenuToUserProfile())
            binding?.tvBottomSheet?.id -> bottomSheet()
        }
    }


    fun bottomSheet(){
        object : GeneralBottomSheetDialog<BottomSheetBinding>(mainActivity){
            override fun getViewBinding() = BottomSheetBinding.inflate(layoutInflater)

            override fun onLayoutCreated(view: GeneralBottomSheetDialog<BottomSheetBinding>) {
                binding.btn.setOnClickListener{
                    findNavController().navigate(MenuFragmentDirections.actionMenuToOrders())
                }
            }


        }.dismissible().show()
    }


}



