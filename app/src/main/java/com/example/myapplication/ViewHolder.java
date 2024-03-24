package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    public ViewHolder(@NonNull View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.cardView);
    }
}
