package com.example.second.ui.productapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.second.R

class ProductAdapter (private val originalItems: List<GetAllProductsData>) :
    RecyclerView.Adapter<ProductAdapter.ItemViewHolder>() , Filterable {
    //filterable used for filteration

    var filteredItems = originalItems

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val description: TextView = itemView.findViewById(R.id.description)
        private val price: TextView = itemView.findViewById(R.id.price)
        private val productImage: ImageView = itemView.findViewById(R.id.product_img)


        fun setData(getAllProductsData: GetAllProductsData) {
            name.text = getAllProductsData.nameEn
            description.text = getAllProductsData.descriptionEn
            price.text = getAllProductsData.price.toString()

            // Load image from URL using Glide
            Glide.with(productImage.context)
                .load(getAllProductsData.image)
                .placeholder(R.drawable.ic_launcher_background) // Optional: A placeholder image to be displayed while the actual image is loading
                .error(R.drawable.ic_notifications_black_24dp) // Optional: An error image to be displayed if the image cannot be loaded
                .into(productImage)

        }
    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setData(filteredItems[position])

    }

    override fun getItemCount()= filteredItems.size
    override fun getFilter(): Filter {
    return object :Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
        val query = constraint.toString().lowercase().trim()
            val filteredList = if (query.isEmpty()) {
                originalItems  }
            else {
                originalItems.filter {
                    it.nameEn?.contains(query, ignoreCase = true) == true ||
                            it.nameAr?.contains(query,ignoreCase = true) == true ||
                            it.descriptionEn?.contains(query,ignoreCase = true) == true
                }
            }
            val results = FilterResults()
            results.values=filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            filteredItems = results?.values as List<GetAllProductsData>
            notifyDataSetChanged()
        }

    }


    }


}
