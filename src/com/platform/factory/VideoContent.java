package com.platform.factory;

import com.platform.model.LearningContent;

public class VideoContent extends LearningContent {
    private String videoUrl;
    private String resolution;
    
    public VideoContent(String title, String description, int durationMinutes, String videoUrl, String resolution) {
        super(title, description, durationMinutes);
        this.videoUrl = videoUrl;
        this.resolution = resolution;
    }
    
    @Override
    public String getContentType() {
        return "Video";
    }
    
    @Override
    public String getContentDetails() {
        return videoUrl + " (" + resolution + ")";
    }
    
    public String getVideoUrl() { return videoUrl; }
    public String getResolution() { return resolution; }
}
