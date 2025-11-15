package com.platform.strategy;

import com.platform.model.Course;
import com.platform.model.Student;
import java.util.List;
import java.util.ArrayList;

public class DifficultyBasedStrategy implements RecommendationStrategy {
    
    @Override
    public List<Course> recommend(Student student, List<Course> availableCourses) {
        List<Course> recommendations = new ArrayList<>();
        String studentLevel = student.getLevel().toLowerCase();
        
        for (Course course : availableCourses) {
            String courseDifficulty = course.getDifficulty().toLowerCase();
            
            // Recommend courses matching student level or slightly above
            if (shouldRecommend(studentLevel, courseDifficulty)) {
                recommendations.add(course);
            }
        }
        
        return recommendations.subList(0, Math.min(3, recommendations.size()));
    }
    
    private boolean shouldRecommend(String studentLevel, String courseDifficulty) {
        if (studentLevel.equals("beginner")) {
            return courseDifficulty.equals("beginner") || courseDifficulty.equals("intermediate");
        } else if (studentLevel.equals("intermediate")) {
            return courseDifficulty.equals("intermediate") || courseDifficulty.equals("advanced");
        } else if (studentLevel.equals("advanced")) {
            return courseDifficulty.equals("advanced");
        }
        return false;
    }
    
    @Override
    public String getStrategyName() {
        return "Difficulty-Based Recommendation";
    }
}
