package com.example.second.ui.network

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.second.databinding.WebViewBinding

class WebViewFragment   : Fragment() {
    private var binding: WebViewBinding? = null

    private var webView: WebView?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WebViewBinding.inflate(inflater, container, false)
        return binding?.root

    }
    @SuppressLint("SetJavaScriptEnabled")
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }

    fun viewwebpage111(){
        binding?.webView?.apply {
            settings.javaScriptEnabled = true
            webViewClient = MyWebViewClient()
            loadUrl("http://www.alesayidistribution.com/mobilehtml/privacy.html")
        }
    }

    private inner class MyWebViewClient : WebViewClient() {
        // Override URL loading to load all URLs within the WebView
        @Deprecated("Deprecated in Java")
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url ?: "")
            return true
        }
    }

}