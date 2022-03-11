package com.example.appmspr

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    //val myWebView : WebView = findViewById(R.id.webView)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myWebView : WebView = findViewById(R.id.webView)
        myWebView.loadUrl("https://www.google.fr/")

        myWebView.settings.javaScriptEnabled = true

    }

}