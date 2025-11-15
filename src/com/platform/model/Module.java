package com.platform.model;

import java.util.ArrayList;
import java.util.List;

public class Module {
    private String name;
    private String description;
    private int durationMinutes;
    private List<LearningContent> contents;
    private boolean completed;
    
    public Module(String name, String description, int durationMinutes) {
        this.name = name;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.contents = new ArrayList<>();
        this.completed = false;
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    
    public List<LearningContent> getContents() { return contents; }
    public void addContent(LearningContent content) { this.contents.add(content); }
    
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    
    public void markCompleted() { this.completed = true; }
}
