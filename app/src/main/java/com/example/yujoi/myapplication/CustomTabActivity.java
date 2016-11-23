package com.example.yujoi.myapplication;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by yujoi on 2016/11/06.
 */
public class CustomTabActivity extends AppCompatActivity {

    private String TAG = "CustomTabs";

    private CustomTabsSession mCustomTabsSession;
    private CustomTabsClient mClient;
    private CustomTabsServiceConnection mConnection;
    private String mPackageNameToBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //test commit
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
