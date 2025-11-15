package com.platform.strategy;

import com.platform.model.Course;
import com.platform.model.Student;
import java.util.List;

public interface RecommendationStrategy {
    List<Course> recommend(Student student, List<Course> availableCourses);
    String getStrategyName();
}
