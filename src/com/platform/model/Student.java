package com.platform.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String email;
    private String level;
    private List<Course> enrolledCourses;
    private List<String> completedModules;
    private List<String> notifications;
    
    public Student(String name, String email, String level) {
        this.name = name;
        this.email = email;
        this.level = level;
        this.enrolledCourses = new ArrayList<>();
        this.completedModules = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getLevel() { return level; }
    
    public List<Course> getEnrolledCourses() { return enrolledCourses; }
    public void enrollInCourse(Course course) { this.enrolledCourses.add(course); }
    
    public List<String> getCompletedModules() { return completedModules; }
    public void addCompletedModule(String moduleName) { this.completedModules.add(moduleName); }
    
    public List<String> getNotifications() { return notifications; }
    public void addNotification(String notification) { this.notifications.add(notification); }
    
    public int getTotalCoursesEnrolled() { return enrolledCourses.size(); }
    public int getTotalModulesCompleted() { return completedModules.size(); }
}
