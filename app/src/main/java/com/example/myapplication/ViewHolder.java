package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    Context context;
    List<Cards> cards;
    List<Cards> filteredCards;
    ImageView imageView;
    public ViewHolder(@NonNull View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.cardView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        if (position!= RecyclerView.NO_POSITION){
            Cards clickedCard = filteredCards.get(position);
        }
    }
}
