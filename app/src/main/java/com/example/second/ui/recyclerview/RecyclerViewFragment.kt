package com.example.second.ui.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.second.databinding.RecyclerViewBinding

class RecyclerViewFragment : Fragment() {
    private var binding : RecyclerViewBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = RecyclerViewBinding.inflate(inflater,container,false)
       return binding?.root    // return view kamel "xml"
    }

    private fun getAdapterList() =
        listOf(
            RecyclerViewModel("Maha", "Name ", "Abu - Adass"),
            RecyclerViewModel("ALi", "Mohammad ", "Mohammad"),
            RecyclerViewModel("Ahmad", "ali", "Ali")
        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RecyclerViewAdapter(getAdapterList(),
            object : RecyclerViewAdapter.NotificationCallback
            {
                override fun itemClicked(item: RecyclerViewModel) {
        //          findNavController().navigate(Recy)
                }

            }   )

        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = adapter

    }
}