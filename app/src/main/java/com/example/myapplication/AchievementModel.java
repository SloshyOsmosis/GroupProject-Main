package com.example.myapplication;

public class AchievementModel {
    String achievementTitle;
    String achievementProgress;

    public AchievementModel(String achievementTitle, String achievementProgress) {
        this.achievementTitle = achievementTitle;
        this.achievementProgress = achievementProgress;

    }

    public String getAchievementTitle() {
        return achievementTitle;
    }

    public String getAchievementProgress() {
        return achievementProgress;
    }

}
