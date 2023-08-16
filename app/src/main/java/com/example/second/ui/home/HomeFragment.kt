package com.example.second.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.second.databinding.FragmentHomeBinding
import com.example.second.ui.base_ui.BaseFragment

class HomeFragment : BaseFragment() {
 private val args by navArgs<HomeFragmentArgs>()

    private var _binding: FragmentHomeBinding? = null

    override fun initToolbar() {
        super.initToolbar()
        setToolbarTitle("Home Title")


        toolbarHomeButton{
            Toast.makeText(activity,"Home Icon", Toast.LENGTH_SHORT).show()
        }
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textHome.setOnClickListener{
         findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToFromSharedPreFragment())

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}