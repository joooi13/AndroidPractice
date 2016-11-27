package com.example.joy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * Created by yujoi on 2016/11/06.
 */
public class WebViewActivity extends Activity {

    private String TAG = "CustomTabs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        String url = getIntent().getStringExtra("url");

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(url);
        myWebView.getSettings().setJavaScriptEnabled(true);

    }
}
