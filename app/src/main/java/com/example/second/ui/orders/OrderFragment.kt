package com.example.second.ui.orders

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
import com.example.second.databinding.OrderListBinding

class OrdersFragment : Fragment() {
    private var binding: OrderListBinding? = null

    private var ordersViewModels: OrderViewModel? = null

    private val PREFS_NAME = "MyPrefsFile"
    private val KEY_NAME = "name"
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OrderListBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observeViewModel()
        initSharedPreferences()
        callMyOrders()

    }

    private fun callMyOrders() {
        ordersViewModels?.getOrders(sharedPreferences?.getString(KEY_NAME, "") ?: "")
    }

    private fun observeViewModel() {
        ordersViewModels = ViewModelProvider(this)[OrderViewModel::class.java]

        ordersViewModels?.getOrders?.observe(viewLifecycleOwner) {
            it?.let {
                ordersAdapter(it)
            }
        }
        ordersViewModels?.getOrdersError?.observe(viewLifecycleOwner) {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    private fun ordersAdapter(items: List<MyOrdersData>) {
        val adapter = OrdersAdapter(items) {

    findNavController().navigate(OrdersFragmentDirections.actionOrdersToOrderDetails(it))


        }
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = adapter

    }

    private fun initSharedPreferences() {
        sharedPreferences = activity?.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )
    }

    private fun init() {

    }


}