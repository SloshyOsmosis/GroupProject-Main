package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalanderViewHolder> {
    private final ArrayList<String> dayOfMonth ;
    private final OnItemListener OnItemListener;

    public CalendarAdapter(ArrayList<String> dayOfMonth, OnItemListener onItemListner) {
        this.dayOfMonth = dayOfMonth;
        this.OnItemListener = onItemListner;
    }

    @NonNull
    @Override
    public CalanderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_day, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight()* 0.16666666666);
        return new CalanderViewHolder(view, OnItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalanderViewHolder holder, int position) {
        holder.dayofMonth.setText(dayOfMonth.get(position));
    }

    @Override
    public int getItemCount() {
        return dayOfMonth.size();
    }


    public interface OnItemListener {
        void onItemClick(int position, String dayText);
    }
}
