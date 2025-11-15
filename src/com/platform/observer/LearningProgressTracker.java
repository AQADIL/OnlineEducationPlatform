package com.platform.observer;

import java.util.ArrayList;
import java.util.List;

public class LearningProgressTracker {
    private List<StudentObserver> observers;
    
    public LearningProgressTracker() {
        this.observers = new ArrayList<>();
    }
    
    public void addObserver(StudentObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(StudentObserver observer) {
        observers.remove(observer);
    }
    
    public void notifyModuleCompleted(String studentName, String moduleName, String courseName) {
        for (StudentObserver observer : observers) {
            observer.onModuleCompleted(studentName, moduleName, courseName);
        }
    }
    
    public void notifyAssignmentGraded(String studentName, String assignmentName, int score, int maxScore) {
        for (StudentObserver observer : observers) {
            observer.onAssignmentGraded(studentName, assignmentName, score, maxScore);
        }
    }
}
