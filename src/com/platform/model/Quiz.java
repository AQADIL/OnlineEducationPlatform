package com.platform.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String title;
    private String description;
    private int timeLimit;
    private List<String> questions;
    private int maxScore;
    
    public Quiz(String title, String description, int timeLimit) {
        this.title = title;
        this.description = description;
        this.timeLimit = timeLimit;
        this.questions = new ArrayList<>();
        this.maxScore = 0;
    }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public int getTimeLimit() { return timeLimit; }
    public void setTimeLimit(int timeLimit) { this.timeLimit = timeLimit; }
    
    public List<String> getQuestions() { return questions; }
    public void addQuestion(String question) { 
        this.questions.add(question);
        this.maxScore += 10; // Each question worth 10 points
    }
    
    public int getMaxScore() { return maxScore; }
    public int getTotalQuestions() { return questions.size(); }
}
