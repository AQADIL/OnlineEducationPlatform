package com.platform.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private String description;
    private String difficulty;
    private List<Module> modules;
    private List<Quiz> quizzes;
    
    public Course() {
        this.modules = new ArrayList<>();
        this.quizzes = new ArrayList<>();
    }
    
    public Course(String title, String description, String difficulty) {
        this();
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
    }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    
    public List<Module> getModules() { return modules; }
    public void setModules(List<Module> modules) { this.modules = modules; }
    public void addModule(Module module) { this.modules.add(module); }
    
    public List<Quiz> getQuizzes() { return quizzes; }
    public void setQuizzes(List<Quiz> quizzes) { this.quizzes = quizzes; }
    public void addQuiz(Quiz quiz) { this.quizzes.add(quiz); }
    
    public int getTotalModules() { return modules.size(); }
    public int getTotalQuizzes() { return quizzes.size(); }
}
