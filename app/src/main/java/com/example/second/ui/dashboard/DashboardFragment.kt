package com.example.second.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.second.databinding.FragmentDashboardBinding
import com.example.second.ui.FirstFragment
import com.example.second.ui.SecondFragment
import com.example.second.ui.home.HomeFragmentDirections
import com.example.second.ui.viewpager.ViewPagerAdapter

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
 //   private val tabTitles =  arrayOf("First", "Second")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.tvDashboard?.setOnClickListener(){
            findNavController().navigate(DashboardFragmentDirections.actionNavigationDashboardToViewPager())
        }
    }




     override    fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
