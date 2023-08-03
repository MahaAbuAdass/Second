package com.example.second.ui
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.second.R
import com.example.second.databinding.MenuFragmentBinding
import com.example.second.ui.network.WebViewFragment

class MenuFragment : Fragment() , OnClickListener {
    private var binding: MenuFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MenuFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
initiate()
    }

    private fun initiate() {
        binding?.privacyPolicy?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding?.privacyPolicy?.id -> {
                openWebPages()
            }

            binding?.aboutUs?.id -> {
            }
        }
    }
     private fun openWebPages() {
            // Replace with the URLs you want to open
//            val url1 = "https://www.google.com"
//            val url2 = "https://www.example2.com"

            val webViewFragment = WebViewFragment()
            parentFragmentManager?.beginTransaction()
                ?.add(R.id.webView, webViewFragment, "WebViewFragment")?.commit()

            // Load the web pages in WebViewFragment
            webViewFragment.viewwebpage111()
//            webViewFragment.loadUrl(url2)
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



