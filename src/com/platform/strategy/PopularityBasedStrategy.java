package com.platform.strategy;

import com.platform.model.Course;
import com.platform.model.Student;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PopularityBasedStrategy implements RecommendationStrategy {
    
    @Override
    public List<Course> recommend(Student student, List<Course> availableCourses) {
        List<Course> recommendations = new ArrayList<>(availableCourses);
        
        // Sort by total modules (higher module count = more popular)
        Collections.sort(recommendations, new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return Integer.compare(c2.getTotalModules(), c1.getTotalModules());
            }
        });
        
        // Return top 3 most popular courses
        return recommendations.subList(0, Math.min(3, recommendations.size()));
    }
    
    @Override
    public String getStrategyName() {
        return "Popularity-Based Recommendation";
    }
}
