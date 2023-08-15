package com.example.second.ui.userinfo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.second.databinding.UserInfoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UserInfoFragment : Fragment() , OnClickListener {
    private var binding:UserInfoBinding ?=null
    private var userInfoViewModel : UserInfoViewModel?=null
    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserInfoBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        nitiatSharedPreference()
        observerVideModel()
        callGetUserApi()
        handleBackPress() // to apply the update api from the back from mobile also

    }
    private fun handleBackPress() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    callUpdateInfo()
                }
            }
            )
    }

    fun updateInfo() = UpdateMyInfoRequest(
        name = binding?.etName?.text.toString(),
        email = binding?.etEmail?.text.toString(),
        businessName = binding?.etBuisnessName?.text.toString(),
        businessType = binding?.etBuisnessType?.text.toString(),
        site = binding?.etSite?.text.toString()
    )



    private fun nitiatSharedPreference() {
        sharedPreferences = activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)    }

    private fun observerVideModel() {
        userInfoViewModel = ViewModelProvider(this)[UserInfoViewModel::class.java]
        userInfoViewModel?.getInfoResponse?.observe(viewLifecycleOwner){
            CoroutineScope(Dispatchers.Main).launch {

                binding?.etName?.setText(it?.data?.name.toString())
                binding?.etNumber?.setText(it?.data?.mobileNumber.toString())
                binding?.etEmail?.setText(it?.data?.email.toString())
                binding?.etSite?.setText(it?.data?.site.toString())
                binding?.etBuisnessName?.setText(it?.data?.businessName.toString())
                binding?.etBuisnessType?.setText(it?.data?.businessType.toString())
            }
        }
            userInfoViewModel?.getInfoError?.observe(viewLifecycleOwner){
                binding?.errorText?.text=it.toString()
            }

        userInfoViewModel?.updateInfoResponse?.observe(viewLifecycleOwner){
            CoroutineScope(Dispatchers.Main).launch {
                findNavController().popBackStack()  /// to back to previous screen
            }

        userInfoViewModel?.updateInfoError?.observe(viewLifecycleOwner){
            CoroutineScope(Dispatchers.Main).launch {
                binding?.errorText?.text=it.toString()
            }
        }

        }


    }

    private fun callGetUserApi() {
        CoroutineScope(Dispatchers.IO).launch {
            userInfoViewModel?.getUserInfoDate(sharedPreferences?.getString(KEY_NAME, "") ?: "")
        }
    }

    private fun init(){
        binding?.btnUpdate?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when (v?.id) {
           binding?.btnUpdate?.id -> callUpdateInfo()
       }
    }


    private fun callUpdateInfo(){
        CoroutineScope(Dispatchers.IO).launch {
            userInfoViewModel?.updateUserInfo(
                updateInfo(), sharedPreferences?.getString(KEY_NAME, "") ?: ""
            )
        }
    }


}