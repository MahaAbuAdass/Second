package com.example.second.ui.orders.orderdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.second.databinding.OrderDetailsBinding
import com.example.second.ui.addresses.edit.EditAddressFragmentArgs

class OrderDetailsFragment : Fragment() {
    private var binding : OrderDetailsBinding ?= null
    private val navArgs by navArgs<OrderDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OrderDetailsBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.tvOrderNumber?.text = navArgs.orderInfo.orderId.toString()
        binding?.tvOrderStatus?.text = navArgs.orderInfo.status.toString()
        binding?.tvDeliveryTo?.text = navArgs.orderInfo.contactPersonName
        binding?.tvOrderDate?.text= navArgs.orderInfo.createDate
        binding?.tvPrice?.text = navArgs.orderInfo.totalPrice.toString()

    }

}