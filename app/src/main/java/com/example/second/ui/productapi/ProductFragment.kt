package com.example.second.ui.productapi

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.second.databinding.ProductBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductFragment : Fragment() {
    private var binding: ProductBinding? = null
    private var adapter: ProductAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productViewModel =
            ViewModelProvider(this)[ProductViewModel::class.java]
        CoroutineScope(Dispatchers.IO).launch {
            productViewModel.getAllProduct()

        }
        productViewModel.productResponse.observe(viewLifecycleOwner) { productResponse ->
            productAdapter(productResponse.data)
        }
        productViewModel.productResponseError.observe(viewLifecycleOwner) { productResponseError ->

            Toast.makeText(activity, productResponseError, Toast.LENGTH_SHORT).show()
        }


        binding?.search?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter?.filter?.filter(s)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun productAdapter(items: List<GetAllProductsData>) {
         adapter = ProductAdapter(items)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = adapter
    }
}