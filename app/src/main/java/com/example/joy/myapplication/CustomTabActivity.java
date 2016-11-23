package com.example.joy.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by yujoi on 2016/11/06.
 */
public class CustomTabActivity extends AppCompatActivity {

    private String TAG = "CustomTabs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_tab_view);

        String url = "http://www.yahoo.co.jp/";

        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));

        builder.setToolbarColor(ContextCompat.getColor(this, R.color.primary));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
