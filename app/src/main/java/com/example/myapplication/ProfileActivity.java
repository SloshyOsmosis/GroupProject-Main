package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    ArrayList<AchievementModel> achievementModels = new ArrayList<>();
    ImageButton achievementBtn, changeBtn;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        achievementBtn = findViewById(R.id.viewAchievementsBtn);

        changeBtn = findViewById(R.id.changeInfoBtn);
        setUpAchievementModels();

        achievementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopUpWindow();
            }
        });
    }

    private void createPopUpWindow() {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.achievmentpopup, null);
        FrameLayout frameLayout = popUpView.findViewById(R.id.frameLayout);
        RecyclerView recyclerView = popUpView.findViewById(R.id.mRecyclerView);
        Achievement_RecyclerViewAdapter adapter = new Achievement_RecyclerViewAdapter(this,
                achievementModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);
        popupWindow.showAtLocation(frameLayout, Gravity.BOTTOM, 0, 0);
        popUpView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    private void setUpAchievementModels() {
        String[] achievementTitles = getResources().getStringArray(R.array.achievement_titles);
        String[] achievementProgress = getResources().getStringArray(R.array.achievement_progress);

        for (int i = 0; i<achievementTitles.length; i++) {
            achievementModels.add(new AchievementModel(achievementTitles[i],
                    achievementProgress[i]));
        }
    }
}