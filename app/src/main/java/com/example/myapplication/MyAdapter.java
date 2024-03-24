package com.example.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.media.RouteListingPreference;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<Cards> cards;
    public MyAdapter(Context context, List<Cards> cards){
        this.context = context;
        this.cards = cards;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_view,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(cards.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return cards.size();
    }
}
