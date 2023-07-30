package com.example.second.ui.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.second.databinding.RecyclerViewBinding

class REcyclerViewFragment2 : Fragment() {

    private var binding: RecyclerViewBinding? = null

    private fun getAdapterList() =
        listOf(
            RecyclerViewModel("Maha", "Name ", "Abu - Adass"),
            RecyclerViewModel("ALi", "Mohammad ", "Mohammad"),
            RecyclerViewModel("ALi", "Mohammad ", "Mohammad"),
            RecyclerViewModel("ALi", "Mohammad ", "Mohammad"),
            RecyclerViewModel("Ahmad", "ali", "Ali")

        )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RecyclerViewBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = getAdapter()
    }

    private fun getAdapter(): SecondAdapter {
        val adapter = SecondAdapter(getAdapterList(),
            object : SecondAdapter.NotificationCallback2 {
                override fun itemClicked(item: RecyclerViewModel) {
                    //          findNavController().navigate(Recy)
                }

            })

        return adapter
    }
}