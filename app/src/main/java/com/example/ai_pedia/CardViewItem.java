package com.example.ai_pedia;

public class CardViewItem {
    private int imageResource;
    private String title;
    private String description;
    private Class<?> activityClass;

    public CardViewItem(int imageResource, String title, String description, Class<?> activityClass) {
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
        this.activityClass = activityClass;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Class<?> getActivityClass() {
        return activityClass;
    }
}
