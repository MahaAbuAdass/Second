package com.example.second.ui.addresses

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.second.R

class UserAddressesAdapter (
    val items: ArrayList<GetCustomerAddressesData>,  // make it array list to be able to edit it
    val deleteClicked: (getAllAddresses: GetCustomerAddressesData) -> Unit,  // to send function on constructor + unit if there is no return for the function
    // if the function has retrun type then it will be added mkan el Unit
    val editClicked: (getAllAddresses: GetCustomerAddressesData) -> Unit
) :

    RecyclerView.Adapter<UserAddressesAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val city: TextView = itemView.findViewById(R.id.tv_city)
        private val address1: TextView = itemView.findViewById(R.id.tv_address1)
        private val address2: TextView = itemView.findViewById(R.id.tv_address2)
        private val longitude: TextView = itemView.findViewById(R.id.tv_longitude)
        private val latitude: TextView = itemView.findViewById(R.id.tv_latitude)
        val edit: TextView = itemView.findViewById(R.id.tv_edit)
        private val delete: TextView = itemView.findViewById(R.id.tv_delete)


        @SuppressLint("SetTextI18n")
        fun initHolder(getAllAddresses: GetCustomerAddressesData) {
            city.text = "City : ${getAllAddresses.city}"
            address1.text = "Address 1 : ${getAllAddresses.address1}"
            address2.text = "Address 2 : ${getAllAddresses.address2}"
            longitude.text = "Longitude : ${getAllAddresses.longitude}"
            latitude.text = "Latitude : ${getAllAddresses.latitude}"
            itemCLicked(getAllAddresses)
        }

        fun itemCLicked(getAllAddresses: GetCustomerAddressesData) {
            edit.setOnClickListener {
                editClicked.invoke(getAllAddresses)

            }
            delete.setOnClickListener {
                deleteClicked.invoke(getAllAddresses)

            }
//            three({ one() })
        }
    }

    //    fun three(xx:()->Int){
//
//    }
//    fun one():Int{
//        return  5
//    }
//    fun two(){
//
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAddressesAdapter.ItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.address_cell, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAddressesAdapter.ItemViewHolder, position: Int) {
        holder.initHolder(items[position])
    }

    override fun getItemCount() = items.size


}


