package com.example.second.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.second.databinding.FragmentDashboardBinding
import com.example.second.ui.First
import com.example.second.ui.Second
import com.example.second.ui.ViewAdapter

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val tabTitles by lazy {
        arrayOf("First", "Second")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

        val adapter = activity?.let {
            ViewAdapter(it, First(), Second())



            binding.viewPager.adapter = adapter



            val textView: TextView = binding.textDashboard
            dashboardViewModel.text.observe(viewLifecycleOwner) {
                textView.text = it
            }
            return root
        }

        fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
}