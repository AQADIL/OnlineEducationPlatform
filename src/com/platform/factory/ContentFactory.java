package com.platform.factory;

import com.platform.model.LearningContent;

public class ContentFactory {
    
    public static LearningContent createContent(String type, String title, String description, int duration, String... params) {
        switch (type.toLowerCase()) {
            case "video":
                String videoUrl = params.length > 0 ? params[0] : "default-video-url.mp4";
                String resolution = params.length > 1 ? params[1] : "1080p";
                return new VideoContent(title, description, duration, videoUrl, resolution);
                
            case "text":
                String textBody = params.length > 0 ? params[0] : "Default text content body with educational material.";
                return new TextContent(title, description, duration, textBody);
                
            case "interactive":
                String interactionType = params.length > 0 ? params[0] : "simulation";
                int interactions = params.length > 1 ? Integer.parseInt(params[1]) : 5;
                return new InteractiveContent(title, description, duration, interactionType, interactions);
                
            default:
                throw new IllegalArgumentException("Unknown content type: " + type);
        }
    }
}
