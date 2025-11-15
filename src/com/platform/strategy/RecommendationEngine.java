package com.platform.strategy;

import com.platform.model.Course;
import com.platform.model.Student;
import java.util.List;

public class RecommendationEngine {
    private RecommendationStrategy strategy;
    
    public RecommendationEngine(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }
    
    public List<Course> generateRecommendations(Student student, List<Course> availableCourses) {
        return strategy.recommend(student, availableCourses);
    }
    
    public String getCurrentStrategyName() {
        return strategy.getStrategyName();
    }
}
