package com.platform.adapter;

import java.util.HashMap;
import java.util.Map;

// Legacy system with different interface
public class LegacyQuizSystem {
    private Map<String, String[]> quizDatabase;
    
    public LegacyQuizSystem() {
        this.quizDatabase = new HashMap<>();
        initializeLegacyQuizzes();
    }
    
    private void initializeLegacyQuizzes() {
        quizDatabase.put("java-basics", new String[]{
            "What is JVM?",
            "Explain inheritance",
            "What are access modifiers?"
        });
        
        quizDatabase.put("data-structures", new String[]{
            "What is a linked list?",
            "Explain binary trees",
            "What is time complexity?"
        });
    }
    
    public String[] getQuizQuestions(String quizId) {
        return quizDatabase.get(quizId);
    }
    
    public String getQuizName(String quizId) {
        return quizId.replace("-", " ").toUpperCase();
    }
    
    public int getQuizDuration(String quizId) {
        return quizDatabase.get(quizId).length * 5; // 5 minutes per question
    }
}
