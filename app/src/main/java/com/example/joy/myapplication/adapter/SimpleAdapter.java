package com.example.joy.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.joy.myapplication.ViewHolder;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by yujoi on 2016/12/21.
 */
public class SimpleAdapter extends RecyclerView.Adapter<ViewHolder> {

    @NonNull
    private List<String> data;

    public SimpleAdapter(@NonNull List<String> data){
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return (ViewHolder) ViewHolder.create(inflater,parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final String text = data.get(position);
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public boolean isHeader(int position){

        if(position % 10 == 0 ){
            return true;
        }
        return false;
    }
}
