package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderHistory_RecyclerViewAdapter extends RecyclerView.Adapter<OrderHistory_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<OrderHistoryModel> orderHistoryModels;
    public OrderHistory_RecyclerViewAdapter(Context context, ArrayList<OrderHistoryModel> orderHistoryModels) {
        this.context = context;
        this.orderHistoryModels = orderHistoryModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.orderhistorycard, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvOrderHistory.setText(orderHistoryModels.get(position).getOrderStatus());
        holder.tvDeliveryDate.setText(orderHistoryModels.get(position).getDeliveryDate());
        holder.imageView.setImageResource(orderHistoryModels.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return orderHistoryModels.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvOrderHistory, tvDeliveryDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvOrderHistory = itemView.findViewById(R.id.textView);
            tvDeliveryDate = itemView.findViewById(R.id.textView2);
        }
    }
}
