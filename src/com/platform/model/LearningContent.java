package com.platform.model;

public abstract class LearningContent {
    protected String title;
    protected String description;
    protected int durationMinutes;
    
    public LearningContent(String title, String description, int durationMinutes) {
        this.title = title;
        this.description = description;
        this.durationMinutes = durationMinutes;
    }
    
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getDurationMinutes() { return durationMinutes; }
    
    public abstract String getContentType();
    public abstract String getContentDetails();
}
