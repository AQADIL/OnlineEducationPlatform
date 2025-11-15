package com.platform.observer;

public interface StudentObserver {
    void onModuleCompleted(String studentName, String moduleName, String courseName);
    void onAssignmentGraded(String studentName, String assignmentName, int score, int maxScore);
}
