package com.example.joy.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by yujoi on 2017/04/12.
 */

public class ImageSampleActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.image_sample);

        //Glide
        //commit???
        ImageView imageView = (ImageView) findViewById(R.id.img);
        Glide.with(this).load("https://goo.gl/rjX8kD").into(imageView);
    }
}
