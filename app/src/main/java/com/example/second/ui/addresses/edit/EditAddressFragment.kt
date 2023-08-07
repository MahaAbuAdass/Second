package com.example.second.ui.addresses.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.second.databinding.EditAddressBinding

class EditAddressFragment : Fragment() {

    private var binding: EditAddressBinding? = null
    private val navargs by navArgs<EditAddressFragmentArgs>()

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


        //set text when pass value to edit text
        binding?.etCity?.setText(navargs.addressInfo.city)
        binding?.etAddress1?.setText((navargs.addressInfo.address1))
        binding?.etAddress2?.setText(navargs.addressInfo.address2)
        binding?.etLatitude?.setText(navargs.addressInfo.latitude)
        binding?.etLongitude?.setText(navargs.addressInfo.longitude)


    }

}