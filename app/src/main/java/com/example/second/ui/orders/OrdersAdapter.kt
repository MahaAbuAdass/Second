package com.example.second.ui.orders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.second.databinding.OrderCellBinding
import com.example.second.enums.OrderStatusEnum


class OrdersAdapter(
    private val items: List<MyOrdersData>, val itemViewClicked: (MyOrdersData) -> Unit
) : RecyclerView.Adapter<OrdersAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: OrderCellBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(myOrdersData: MyOrdersData) {
            binding.apply {
                tvOrderNumber.text = myOrdersData.orderId.toString()

                //using Enum "replace the returned value with another value , should have else value
                tvOrderStatus.text = when (myOrdersData.status) {
                    OrderStatusEnum.ORDER_56.status-> "status 1"
                    OrderStatusEnum.ORDER_9.status -> "Status 2"
                    OrderStatusEnum.ORDER_7.status -> "Status 3"
                    else -> ""
                }
                tvDeliveryTo.text = myOrdersData.contactPersonName
                tvOrderDate.text = myOrdersData.createDate.toString()
                tvPrice.text = myOrdersData.totalPrice.toString()

                // invoke used when send fun in another fun constructor
                itemView.setOnClickListener {
                    itemViewClicked.invoke(myOrdersData)
                }
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val binding = OrderCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
