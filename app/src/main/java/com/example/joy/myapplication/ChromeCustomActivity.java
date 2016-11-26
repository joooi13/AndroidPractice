package com.example.joy.myapplication;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by yujoi on 2016/11/26.
 */
public class ChromeCustomActivity extends AppCompatActivity implements View.OnClickListener {

    private Button customTabsBtn;
    private Button webViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chrome_custom);

        findById();
        clickListener();
    }

    private void findById() {
        customTabsBtn = (Button) findViewById(R.id.customTabsBtn);
        webViewBtn = (Button) findViewById(R.id.webViewBtn);
    }

    private void clickListener() {
        customTabsBtn.setOnClickListener(this);
        webViewBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.equals(customTabsBtn)) {

            String url = "https://www.rakus.co.jp/";
            final Intent intent = new Intent(Intent.ACTION_SEND)
                    .setType("text/plain")
                    .putExtra(Intent.EXTRA_TEXT, url);

            final PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
            final Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_share_white_24dp);

            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();

            setupMenu(builder);

            final CustomTabsIntent tabsIntent = builder
                    .setShowTitle(true)
                    .setToolbarColor(ContextCompat.getColor(this, R.color.primary))
                    .setCloseButtonIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow_back_white_24dp))
                    .enableUrlBarHiding()
                    .setActionButton(icon, "シェア", pendingIntent).build();


            tabsIntent.launchUrl(this, Uri.parse(url));


        } else if (view.equals(webViewBtn)) {

            Intent intent = new Intent(this, WebViewActivity.class);
            startActivity(intent);
        }
    }

    // メニューの追加
    private void setupMenu(CustomTabsIntent.Builder builder) {

        Intent menuIntent = new Intent();
        //...省略
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, menuIntent, 0);

        builder.addMenuItem("Menu Share Sample", pendingIntent);
    }

}
