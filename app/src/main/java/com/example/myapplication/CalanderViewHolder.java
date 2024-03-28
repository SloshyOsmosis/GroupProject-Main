package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalanderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final TextView dayofMonth;
    private final CalendarAdapter.OnItemListener OnItemListener;
    public CalanderViewHolder(@NonNull View itemView, CalendarAdapter.OnItemListener onItemListner) {
        super(itemView);
        dayofMonth = itemView.findViewById(R.id.cell);
        this.OnItemListener = onItemListner;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        OnItemListener.onItemClick(getAdapterPosition(), (String) dayofMonth.getText());
    }
}
