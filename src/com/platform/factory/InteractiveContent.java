package com.platform.factory;

import com.platform.model.LearningContent;

public class InteractiveContent extends LearningContent {
    private String interactionType;
    private int numberOfInteractions;
    
    public InteractiveContent(String title, String description, int durationMinutes, String interactionType, int numberOfInteractions) {
        super(title, description, durationMinutes);
        this.interactionType = interactionType;
        this.numberOfInteractions = numberOfInteractions;
    }
    
    @Override
    public String getContentType() {
        return "Interactive";
    }
    
    @Override
    public String getContentDetails() {
        return interactionType + " with " + numberOfInteractions + " interactions";
    }
    
    public String getInteractionType() { return interactionType; }
    public int getNumberOfInteractions() { return numberOfInteractions; }
}
