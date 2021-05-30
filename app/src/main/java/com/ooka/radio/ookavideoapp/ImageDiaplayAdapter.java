package com.ooka.radio.ookavideoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class ImageDiaplayAdapter extends RecyclerView.Adapter<ImageDiaplayAdapter.MyViewHolder> {

   private Context context;
   private String imgUrl,title;


    public ImageDiaplayAdapter(FragmentActivity activity, String imageUrl,String title) {
        context = activity;
        imgUrl = imageUrl;
        this.title = title;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_seen_before_end,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(imgUrl).into(holder.img);
        holder.titl.setText(title);
    }

    @Override
    public int getItemCount() {
            return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView titl;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            titl = itemView.findViewById(R.id.title);
        }
    }
}
