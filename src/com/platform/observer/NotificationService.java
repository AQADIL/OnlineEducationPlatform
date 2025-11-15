package com.platform.observer;

public class NotificationService implements StudentObserver {
    
    @Override
    public void onModuleCompleted(String studentName, String moduleName, String courseName) {
        String notification = "Congratulations " + studentName + "! You have completed module: " + moduleName + " in course: " + courseName;
        System.out.println("Notification sent: " + notification);
    }
    
    @Override
    public void onAssignmentGraded(String studentName, String assignmentName, int score, int maxScore) {
        String notification = "Hi " + studentName + ", your assignment '" + assignmentName + "' has been graded. Score: " + score + "/" + maxScore;
        System.out.println("Notification sent: " + notification);
    }
}
