package com.example.second.ui.orders.orderdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.second.databinding.OrderCellBinding
import com.example.second.databinding.OrderDetailsCellBinding
import com.example.second.ui.orders.GetAllProductsData
import com.example.second.ui.orders.MyOrdersData
import com.example.second.ui.orders.OrdersAdapter

class ProductsAdapter (private val items :List <GetAllProductsData>)
    : RecyclerView.Adapter<ProductsAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: OrderDetailsCellBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(getAllProductsData: GetAllProductsData) {

            binding.apply {
                tvName.text = getAllProductsData.nameEn.toString()
                tvDescription.text = getAllProductsData.descriptionEn.toString()
                tvQty.text = getAllProductsData.quantity.toString()
                tvPrice.text = getAllProductsData.price.toString()
            }
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val binding = OrderDetailsCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount()=items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }


    }