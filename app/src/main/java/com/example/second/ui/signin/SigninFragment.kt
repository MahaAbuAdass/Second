package com.example.second.ui.signin

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.second.databinding.LoginFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SigninFragment : Fragment(), OnClickListener {

    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    private var signinViewModel: SigninViewModel? = null
    private var binding: LoginFragmentBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signinViewModel = ViewModelProvider(this)[SigninViewModel::class.java]
        initSharedPreferences()
        observeViewModel()
        initiate()

    }

    private fun initiate() {
        binding?.signIn?.setOnClickListener(this)
        binding?.tvSignup?.setOnClickListener(this)
    }

    private fun observeViewModel() {
        signinViewModel?.loginResponse?.observe(viewLifecycleOwner) {
            val editor = sharedPreferences!!.edit()
            editor.putString(KEY_NAME, it?.token)
            editor.apply()
            findNavController().navigate(SigninFragmentDirections.actionLoginToProduct())
        }
        signinViewModel?.loginResponseError?.observe(viewLifecycleOwner) {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()

            findNavController().navigate(SigninFragmentDirections.

        }
    }

    suspend fun mahaTest(){

    }
    private fun loginRequest() =
        LoginRequest(binding?.phoneNumber?.text.toString(), binding?.password?.text.toString())


    private fun initSharedPreferences() {
        // to send data from screen to another
        sharedPreferences = activity?.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        );  // private to prevent share it  with another app
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding?.signIn?.id -> CoroutineScope(Dispatchers.IO).launch {
                signinViewModel?.login(loginRequest())
//                mahaTest()
//                withContext(Dispatchers.Main){
//                    findNavController().navigate(SigninFragmentDirections.actionLoginToProduct())
//
//                }
            }


            binding?.tvSignup?.id -> findNavController().navigate(SigninFragmentDirections.actionLoginToSignup())
        }

    }
}


