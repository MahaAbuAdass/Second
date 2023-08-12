package com.example.second.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.second.databinding.SignupFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationFragment : Fragment(), OnClickListener {
    private var binding: SignupFragmentBinding? = null
    private var registrationViewModel: RegistrationViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignupFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observerViewModel()
        initiate()
    }

    private fun initiate() {
        binding?.btnRegister?.setOnClickListener(this)
    }

    private fun observerViewModel() {
        registrationViewModel = ViewModelProvider(this)[RegistrationViewModel::class.java]

        registrationViewModel?.registrationResponse?.observe(viewLifecycleOwner) {
            findNavController().navigate(RegistrationFragmentDirections.actionSignupToProduct())
        }
        registrationViewModel?.errorResponse?.observe(viewLifecycleOwner) {
            binding?.tvErrorText?.text = it.toString()
        }
    }

    private suspend fun callSignUp(){
        registrationViewModel?.callRegistrationAPI(RegistrationRequestModel(
            mobileNumber = binding?.ETPhoneNumber?.text.toString(),
            password = binding?.ETPassReg?.text.toString(),
            customerName = binding?.ETFullName?.text.toString(),
            siteCode = binding?.etSiteCode?.text.toString(),
            businessName = binding?.etBuisnessName?.text.toString()

        )
        )

        }
    override fun onClick(p0: View?) {
      when (p0?.id){
          binding?.btnRegister?.id -> {
              // add coroutine scope " suspend fun should call from another suspend fun or using coroutine scope
              CoroutineScope(Dispatchers.IO).launch {
                  callSignUp()
              findNavController().navigate(RegistrationFragmentDirections.actionSignupToProduct())
              }
          }
      }
    }
}