package com.example.second.ui.addresses.edit

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
import androidx.navigation.fragment.navArgs
import com.example.second.databinding.EditAddressBinding
import com.example.second.ui.addresses.AddCustomerAddressRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class EditAddressFragment : Fragment() , OnClickListener{

    private var binding: EditAddressBinding? = null
    private val navargs by navArgs<EditAddressFragmentArgs>()
    private var editAddressViewModel: EditAddressViewModel? = null


    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EditAddressBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observeViewModel()
        initSharedPreferences()


        //set text when pass value to edit text
        binding?.etCity?.setText(navargs.addressInfo.city)
        binding?.etAddress1?.setText((navargs.addressInfo.address1))
        binding?.etAddress2?.setText(navargs.addressInfo.address2)
        binding?.etLatitude?.setText(navargs.addressInfo.latitude)
        binding?.etLongitude?.setText(navargs.addressInfo.longitude)


    }

    private fun initSharedPreferences() {
        sharedPreferences = activity?.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )    }

    private fun observeViewModel() {
          editAddressViewModel = ViewModelProvider(this)[EditAddressViewModel::class.java]
          editAddressViewModel?.updateAddress?.observe(viewLifecycleOwner){
            // add cortineScope if add suspen fun inside not suspend fun
              CoroutineScope(Dispatchers.Main).launch {
                  if (it == true )
                        activity?.onBackPressedDispatcher?.onBackPressed() // when click on back from mobile
                      else  Toast.makeText(context,"NO", Toast.LENGTH_SHORT).show()
                  }
                  }
        editAddressViewModel?.updateAddressError?.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                binding?.errorText?.text = it.toString()
              }

          }


    }



    private fun init(){
        binding?.apply {
            etCity.setText(navargs.addressInfo.city)
            etAddress1.setText(navargs.addressInfo.address1)
            etAddress2.setText(navargs.addressInfo.address2)
            etLongitude.setText(navargs.addressInfo.longitude)
            etLatitude.setText(navargs.addressInfo.latitude)
            btnSave.setOnClickListener(this@EditAddressFragment)
        }

    }
    private fun updateAddress() = AddCustomerAddressRequest(
        city = binding?.etCity?.text.toString(),
        address1 = binding?.etAddress1?.text.toString(),
        address2 = binding?.etAddress2?.text.toString(),
        longitude = binding?.etLongitude?.text.toString(),
        latitude = binding?.etLatitude?.text.toString(),
        contactPersonName = "Maha", contactPersonPhone = "1232141231231",
        id = navargs.addressInfo.addressId
    )

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding?.btnSave?.id -> CoroutineScope(Dispatchers.IO).launch {
                editAddressViewModel?.updateUserAddressAPI(
                    updateAddress(),
                    sharedPreferences?.getString(KEY_NAME, "") ?: ""
                )
            }
        }
    }


}