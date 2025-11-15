package com.platform.adapter;

import com.platform.model.Quiz;

public class QuizAdapter {
    private LegacyQuizSystem legacySystem;
    
    public QuizAdapter(LegacyQuizSystem legacySystem) {
        this.legacySystem = legacySystem;
    }
    
    public Quiz adaptLegacyQuiz(String legacyQuizId) {
        String quizName = legacySystem.getQuizName(legacyQuizId);
        int duration = legacySystem.getQuizDuration(legacyQuizId);
        String[] questions = legacySystem.getQuizQuestions(legacyQuizId);
        
        Quiz modernQuiz = new Quiz(quizName, "Adapted from legacy system", duration);
        
        for (String question : questions) {
            modernQuiz.addQuestion(question);
        }
        
        return modernQuiz;
    }
    
    public boolean isLegacyQuizAvailable(String quizId) {
        return legacySystem.getQuizQuestions(quizId) != null;
    }
}
