package com.platform.bridge;

import com.platform.model.Course;
import com.platform.model.Module;
import com.platform.model.Quiz;

public class DetailedContentPresentation extends ContentPresentation {
    
    public DetailedContentPresentation(PresentationRenderer renderer) {
        super(renderer);
    }
    
    @Override
    public void displayCourse(Course course) {
        renderer.renderTitle(course.getTitle());
        renderer.renderDescription(course.getDescription());
        System.out.println("Difficulty: " + course.getDifficulty());
        System.out.println("Total Modules: " + course.getTotalModules());
        System.out.println("Total Quizzes: " + course.getTotalQuizzes());
        renderer.renderSeparator();
        
        for (Module module : course.getModules()) {
            displayModule(module);
        }
        
        for (Quiz quiz : course.getQuizzes()) {
            renderer.renderQuizInfo(quiz.getTitle(), quiz.getTotalQuestions());
        }
    }
    
    @Override
    public void displayModule(Module module) {
        renderer.renderModuleInfo(module.getName(), module.getDurationMinutes());
        System.out.println("  Status: " + (module.isCompleted() ? "Completed" : "In Progress"));
        System.out.println("  Contents: " + module.getContents().size() + " items");
    }
}
