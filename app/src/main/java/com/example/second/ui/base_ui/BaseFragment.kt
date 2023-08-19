package com.example.second.ui.base_ui

import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.second.MainActivity
import com.example.second.ui.ProgressBarLoader

open class BaseFragment : Fragment() {
    val mainActivity: MainActivity get() = (activity as MainActivity)
    private val progressBarLoading by lazy { ProgressBarLoader(requireContext()) }

    private val myToolbar get() = mainActivity.mainBinding?.toolbar

    open fun initToolbar(){
        myToolbar?.apply {
            titleToolbar.isVisible = false
            HomeToolbar.isVisible = false
        }
        toolbarVisibility(!mainActivity.isMainFragments())   // to hide the tool bar if it not main activity

    }
    fun showProgressLoading() {
        progressBarLoading.show()
    }

    fun hideProgressLoading() {
        progressBarLoading.dismiss()
    }
    fun toolbarHomeButton(onClickListener: View.OnClickListener){
        myToolbar?.HomeToolbar?.isVisible = true
        myToolbar?.HomeToolbar?.setOnClickListener(onClickListener)
    }
    fun toolbarVisibility(isVisible : Boolean){
        myToolbar?.toolbarConstrain?.isVisible = isVisible
    }

    fun setToolbarTitle(title : String){
        myToolbar?.titleToolbar?.apply {
            isVisible=true
            text = title
        }
    }


    // the added on on resume fun will be executed
    override fun onResume() {
        initToolbar()
        super.onResume()
        mainActivity.mainBinding?.navView?.isVisible = mainActivity.isMainFragments()
    }


}