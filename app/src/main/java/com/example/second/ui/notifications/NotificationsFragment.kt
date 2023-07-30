package com.example.second.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.second.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment(), OnClickListener {

    private var _binding: FragmentNotificationsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        _binding?.textNotifications?.setOnClickListener(this)
        _binding?.textNotifications3?.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            _binding?.textNotifications?.id -> findNavController().navigate(
                NotificationsFragmentDirections.actionNavigationNotificationsToNavigationRecyclerViewFragment2()
            )

            _binding?.textNotifications3?.id -> findNavController().navigate(
                NotificationsFragmentDirections.actionNavigationNotificationsToSecondFragment()
            )
        }
    }
}