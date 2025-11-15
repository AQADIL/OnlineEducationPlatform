package com.platform.factory;

import com.platform.model.LearningContent;

public class TextContent extends LearningContent {
    private String textBody;
    private int wordCount;
    
    public TextContent(String title, String description, int durationMinutes, String textBody) {
        super(title, description, durationMinutes);
        this.textBody = textBody;
        this.wordCount = textBody.split("\\s+").length;
    }
    
    @Override
    public String getContentType() {
        return "Text";
    }
    
    @Override
    public String getContentDetails() {
        return wordCount + " words";
    }
    
    public String getTextBody() { return textBody; }
    public int getWordCount() { return wordCount; }
}
