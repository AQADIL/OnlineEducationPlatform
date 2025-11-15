package com.platform.bridge;

public class ConsoleRenderer implements PresentationRenderer {
    
    @Override
    public void renderTitle(String title) {
        System.out.println("=== " + title + " ===");
    }
    
    @Override
    public void renderDescription(String description) {
        System.out.println("Description: " + description);
    }
    
    @Override
    public void renderModuleInfo(String moduleName, int duration) {
        System.out.println("Module: " + moduleName + " (" + duration + " minutes)");
    }
    
    @Override
    public void renderQuizInfo(String quizTitle, int questions) {
        System.out.println("Quiz: " + quizTitle + " (" + questions + " questions)");
    }
    
    @Override
    public void renderSeparator() {
        System.out.println("----------------------------------------");
    }
}
