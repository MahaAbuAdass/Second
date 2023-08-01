package com.example.second.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.second.databinding.ItemListLayoutBinding

class SecondAdapter(
    private val items: List<RecyclerViewModel>?,
    private val notificationCallback2: NotificationCallback2
) : RecyclerView.Adapter<SecondAdapter.MahaHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahaHolder {

        val binding = ItemListLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return MahaHolder(binding)
    }

    override fun getItemCount() = items?.size ?: 0
    override fun onBindViewHolder(holder: MahaHolder, position: Int) {
        holder.setData(items?.get(position),notificationCallback2)
    }

    class MahaHolder(val binding: ItemListLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setData(item: RecyclerViewModel?, notificationCallback2: NotificationCallback2) {
            item?.let { recyclerViewModel ->
                binding.tvFirstName.text = recyclerViewModel.FirstName
                binding.tvSecondName.text = recyclerViewModel.SecondName
                binding.tvId.text = recyclerViewModel.ID

                // Set the click listener
                binding.root.setOnClickListener {
                    notificationCallback2.itemClicked(recyclerViewModel)
                }
            }
        }

    }

    interface NotificationCallback2 {
        fun itemClicked(item: RecyclerViewModel)
    }
}