package com.platform.builder;

import com.platform.model.Course;
import com.platform.model.Module;
import com.platform.model.Quiz;

public class CourseBuilder {
    private Course course;
    
    public CourseBuilder() {
        this.course = new Course();
    }
    
    public CourseBuilder setTitle(String title) {
        course.setTitle(title);
        return this;
    }
    
    public CourseBuilder setDescription(String description) {
        course.setDescription(description);
        return this;
    }
    
    public CourseBuilder setDifficulty(String difficulty) {
        course.setDifficulty(difficulty);
        return this;
    }
    
    public CourseBuilder addModule(String name, String description, int duration) {
        Module module = new Module(name, description, duration);
        course.addModule(module);
        return this;
    }
    
    public CourseBuilder addQuiz(String title, String description, int timeLimit) {
        Quiz quiz = new Quiz(title, description, timeLimit);
        course.addQuiz(quiz);
        return this;
    }
    
    public CourseBuilder addQuizWithQuestions(String title, String description, int timeLimit, String[] questions) {
        Quiz quiz = new Quiz(title, description, timeLimit);
        for (String question : questions) {
            quiz.addQuestion(question);
        }
        course.addQuiz(quiz);
        return this;
    }
    
    public Course build() {
        return course;
    }
}
