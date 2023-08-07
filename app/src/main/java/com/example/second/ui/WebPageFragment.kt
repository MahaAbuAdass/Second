package com.example.second.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.second.databinding.WebViewBinding

class WebPageFragment : Fragment() {
    private var binding : WebViewBinding ?=null

    // to recieve argument
    private val navargs by navArgs<WebPageFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WebViewBinding.inflate(inflater,container,false)
        return binding?.root
    }


    @SuppressLint("SetJavaScriptEnabled")

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding?.webView?.apply {
                settings.javaScriptEnabled = true
                webViewClient = MyWebViewClient()
                loadUrl(navargs.url)
            }


        }

        private inner class MyWebViewClient : WebViewClient() {
            // Override URL loading to load all URLs within the WebView
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url ?: "")
                return true
            }
        }
    }


