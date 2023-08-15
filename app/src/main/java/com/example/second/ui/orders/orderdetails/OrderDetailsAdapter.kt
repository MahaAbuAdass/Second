package com.example.second.ui.orders.orderdetails

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.second.ui.orders.GetAllProductsData
import com.example.second.ui.orders.MyOrdersData
import com.example.second.ui.orders.OrdersAdapter

class OrderDetailsAdapter (private val items :List <GetAllProductsData>)
    : RecyclerView.Adapter<OrdersAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrdersAdapter.ItemViewHolder {
        TODO("Not yet implemented")
    }
 private fun setData(getAllProductsData: GetAllProductsData) {
      name
    }

    override fun getItemCount()=items.size

    override fun onBindViewHolder(holder: OrdersAdapter.ItemViewHolder, position: Int) {
       holder.setData(items[position])
    }


    }