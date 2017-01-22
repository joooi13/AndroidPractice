package com.example.joy.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.joy.myapplication.adapter.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yujoi on 2016/12/21.
 */
public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_sample);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("Item" + i);
        }

        final SimpleAdapter simpleAdapter = new SimpleAdapter(list);

        final GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return simpleAdapter.isHeader(position) ? layoutManager.getSpanCount() : 1;
            }
        });

        mRecyclerView.setLayoutManager(layoutManager);


        mRecyclerView.setAdapter(simpleAdapter);

    }
}
