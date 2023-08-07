package com.example.second.ui.addresses

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.second.databinding.AddressListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserAddressesFragment : Fragment() {
    private var binding: AddressListBinding? = null

    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddressListBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // to send data from screen to another
        sharedPreferences = activity?.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        );  // private to prevent share it  with another app

        val myAuthKey = sharedPreferences?.getString(KEY_NAME, "")


        val userAddressesvViewModel =
            ViewModelProvider(this)[UserAddressesViewModel::class.java]
        CoroutineScope(Dispatchers.IO).launch {
            userAddressesvViewModel.getUserAdresses(myAuthKey ?: "")

        }

        userAddressesvViewModel.getAddresses.observe(viewLifecycleOwner) { addressResponse ->
            addressResponse.data?.let {
                addressesAdapter(it)
            }
        }
        userAddressesvViewModel.getAddressesError.observe(viewLifecycleOwner) {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
        }
    }


    private fun addressesAdapter(items: List<GetCustomerAddressesData>) {
        val adapter = UserAddressesAdapter(items, deleteClicked = {}, editClicked = {
       //     findNavController().navigate(UserAddress.actionUserAddressesToEditAddress(it))
        })
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = adapter


    }
}