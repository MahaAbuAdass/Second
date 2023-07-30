package com.example.second.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.second.databinding.ItemListLayoutBinding

class RecyclerViewAdapter(
    private val items: List<RecyclerViewModel>?,
    private val notificationCallback: NotificationCallback
) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemListLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindData(items?.get(position))
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    inner class ItemViewHolder(private val binding: ItemListLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: RecyclerViewModel?) {
            item?.let { recyclerViewModel ->
                binding.tvFirstName.text = recyclerViewModel.FirstName
                binding.tvSecondName.text = recyclerViewModel.SecondName
                binding.tvId.text = recyclerViewModel.ID

                // Set the click listener
                binding.root.setOnClickListener {
                    notificationCallback.itemClicked(recyclerViewModel)
                }
            }
        }
    }

    interface NotificationCallback {
        fun itemClicked(item: RecyclerViewModel)
    }
}
