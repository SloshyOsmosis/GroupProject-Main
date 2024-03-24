package com.example.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.media.RouteListingPreference;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<Cards> cards;
    List<Cards> filteredCards;
    public MyAdapter(Context context, List<Cards> cards){
        this.context = context;
        this.cards = cards;
        this.filteredCards = new ArrayList<>(cards);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_view,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(filteredCards.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return filteredCards.size();
    }

    public void filterList(List<Cards> filteredList){
        filteredCards.clear();
        filteredCards.addAll(filteredList);
        notifyDataSetChanged();
    }
}
