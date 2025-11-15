package com.platform.app;
import com.platform.builder.CourseBuilder;
import com.platform.factory.ContentFactory;
import com.platform.adapter.LegacyQuizSystem;
import com.platform.adapter.QuizAdapter;
import com.platform.bridge.*;
import com.platform.strategy.*;
import com.platform.observer.*;
import com.platform.model.Course;
import com.platform.model.LearningContent;
import com.platform.model.Module;
import com.platform.model.Quiz;
import com.platform.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Online Education Platform");
        System.out.println("=============================");
        
        // Initialize components
        LearningProgressTracker progressTracker = new LearningProgressTracker();
        NotificationService notificationService = new NotificationService();
        progressTracker.addObserver(notificationService);
        
        // Create students - our development team
        Student[] students = {
            new Student("Alish Akadil", "alish.akadil@student.edu", "advanced"),
            new Student("Zhakhangir Muratov", "zhakhangir.muratov@student.edu", "intermediate"), 
            new Student("Zhanibek Ibyrhanov", "zhanibek.ibyrhanov@student.edu", "beginner")
        };
        
        // Select current student for demo
        Student currentStudent = students[0];
        
        // 1. BUILDER PATTERN - Create course using builder
        System.out.println("\n1. BUILDER PATTERN - Creating Course");
        CourseBuilder builder = new CourseBuilder();
        Course javaCourse = builder
            .setTitle("Advanced Java Programming")
            .setDescription("Comprehensive course covering advanced Java concepts")
            .setDifficulty("intermediate")
            .addModule("Object-Oriented Programming", "Deep dive into OOP principles", 120)
            .addModule("Collections Framework", "Working with Java Collections", 90)
            .addModule("Multithreading", "Concurrent programming in Java", 150)
            .addQuizWithQuestions("Java Fundamentals Quiz", "Test your basic Java knowledge", 30,
                new String[]{"What is polymorphism?", "Explain inheritance", "What are interfaces?"})
            .build();
            
        System.out.println("Course created: " + javaCourse.getTitle());
        System.out.println("Modules: " + javaCourse.getTotalModules() + ", Quizzes: " + javaCourse.getTotalQuizzes());
        
        // 2. FACTORY PATTERN - Create different types of content
        System.out.println("\n2. FACTORY PATTERN - Creating Learning Content");
        LearningContent videoContent = ContentFactory.createContent("video", 
            "Introduction to Java", "Basic Java concepts explained", 45, 
            "java-intro.mp4", "1080p");
        LearningContent textContent = ContentFactory.createContent("text",
            "Java Syntax Guide", "Complete reference for Java syntax", 30,
            "This comprehensive guide covers all aspects of Java syntax including variables, operators, control structures, and method definitions.");
        LearningContent interactiveContent = ContentFactory.createContent("interactive",
            "Java Code Lab", "Hands-on coding exercises", 60,
            "coding-simulator", "8");
            
        System.out.println("Created " + videoContent.getContentType() + ": " + videoContent.getTitle() + " - " + videoContent.getContentDetails());
        System.out.println("Created " + textContent.getContentType() + ": " + textContent.getTitle() + " - " + textContent.getContentDetails());
        System.out.println("Created " + interactiveContent.getContentType() + ": " + interactiveContent.getTitle() + " - " + interactiveContent.getContentDetails());
        
        javaCourse.getModules().get(0).addContent(videoContent);
        javaCourse.getModules().get(0).addContent(textContent);
        javaCourse.getModules().get(0).addContent(interactiveContent);
        
        // 3. ADAPTER PATTERN - Integrate legacy quiz system
        System.out.println("\n3. ADAPTER PATTERN - Integrating Legacy Quiz");
        LegacyQuizSystem legacySystem = new LegacyQuizSystem();
        QuizAdapter quizAdapter = new QuizAdapter(legacySystem);
        
        if (quizAdapter.isLegacyQuizAvailable("java-basics")) {
            Quiz adaptedQuiz = quizAdapter.adaptLegacyQuiz("java-basics");
            javaCourse.addQuiz(adaptedQuiz);
            System.out.println("Legacy quiz adapted: " + adaptedQuiz.getTitle());
            System.out.println("Questions: " + adaptedQuiz.getTotalQuestions() + ", Duration: " + adaptedQuiz.getTimeLimit() + " minutes");
        }
        
        // 4. BRIDGE PATTERN - Display course with different presentations
        System.out.println("\n4. BRIDGE PATTERN - Course Presentation");
        
        System.out.println("\n--- Console View ---");
        ContentPresentation detailedView = new DetailedContentPresentation(new ConsoleRenderer());
        detailedView.displayCourse(javaCourse);
        
        System.out.println("\n--- Minimalistic View ---");
        ContentPresentation summaryView = new SummaryContentPresentation(new MinimalisticRenderer());
        summaryView.displayCourse(javaCourse);
        
        // 5. STRATEGY PATTERN - Course recommendations
        System.out.println("\n5. STRATEGY PATTERN - Course Recommendations");
        
        // Create additional courses
        List<Course> availableCourses = new ArrayList<>();
        availableCourses.add(javaCourse);
        
        Course pythonCourse = new CourseBuilder()
            .setTitle("Python Data Science")
            .setDescription("Learn data science with Python")
            .setDifficulty("beginner")
            .addModule("Python Basics", "Introduction to Python", 60)
            .addModule("NumPy and Pandas", "Data manipulation libraries", 90)
            .build();
        availableCourses.add(pythonCourse);
        
        Course machineLearningCourse = new CourseBuilder()
            .setTitle("Machine Learning Fundamentals")
            .setDescription("Introduction to ML algorithms")
            .setDifficulty("advanced")
            .addModule("Linear Regression", "Basic ML algorithm", 120)
            .addModule("Neural Networks", "Deep learning basics", 180)
            .addModule("Model Evaluation", "Testing ML models", 90)
            .addModule("Feature Engineering", "Data preprocessing", 100)
            .build();
        availableCourses.add(machineLearningCourse);
        
        // Test different recommendation strategies
        RecommendationEngine engine = new RecommendationEngine(new PopularityBasedStrategy());
        System.out.println("Using " + engine.getCurrentStrategyName() + " for " + currentStudent.getName() + ":");
        List<Course> recommendations = engine.generateRecommendations(currentStudent, availableCourses);
        for (Course course : recommendations) {
            System.out.println("- " + course.getTitle() + " (" + course.getDifficulty() + ")");
        }
        
        engine.setStrategy(new DifficultyBasedStrategy());
        System.out.println("\nUsing " + engine.getCurrentStrategyName() + ":");
        recommendations = engine.generateRecommendations(currentStudent, availableCourses);
        for (Course course : recommendations) {
            System.out.println("- " + course.getTitle() + " (" + course.getDifficulty() + ")");
        }
        
        // 6. OBSERVER PATTERN - Simulate learning progress
        System.out.println("\n6. OBSERVER PATTERN - Learning Progress Notifications");

        Module firstModule = javaCourse.getModules().get(0);
        firstModule.markCompleted();
        progressTracker.notifyModuleCompleted(currentStudent.getName(), firstModule.getName(), javaCourse.getTitle());
        
        Quiz quiz = javaCourse.getQuizzes().get(0);
        int studentScore = 85;
        progressTracker.notifyAssignmentGraded(currentStudent.getName(), quiz.getTitle(), studentScore, quiz.getMaxScore());

        Module secondModule = javaCourse.getModules().get(1);
        secondModule.markCompleted();
        progressTracker.notifyModuleCompleted(currentStudent.getName(), secondModule.getName(), javaCourse.getTitle());
        
        System.out.println("\n=============================");
        System.out.println("\nDevelopment Team Summary:");
        for (Student dev : students) {
            System.out.println("- " + dev.getName() + " (" + dev.getLevel() + " level) - " + dev.getTotalCoursesEnrolled() + " courses enrolled");
        }
    }
}
