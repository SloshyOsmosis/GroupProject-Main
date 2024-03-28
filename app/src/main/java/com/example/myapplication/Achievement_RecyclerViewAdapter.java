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

public class Achievement_RecyclerViewAdapter extends RecyclerView.Adapter<Achievement_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<AchievementModel> achievementModels;
    public Achievement_RecyclerViewAdapter(Context context, ArrayList<AchievementModel> achievementModels) {
        this.context = context;
        this.achievementModels = achievementModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.achievement_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTitle.setText(achievementModels.get(position).getAchievementTitle());
        holder.tvProgress.setText(achievementModels.get(position).getAchievementProgress());
    }

    @Override
    public int getItemCount() {
        return achievementModels.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvTitle, tvProgress;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvTitle = itemView.findViewById(R.id.textView);
            tvProgress = itemView.findViewById(R.id.textView2);
        }
    }
}