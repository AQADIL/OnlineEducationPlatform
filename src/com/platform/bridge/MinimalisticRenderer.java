package com.platform.bridge;

public class MinimalisticRenderer implements PresentationRenderer {
    
    @Override
    public void renderTitle(String title) {
        System.out.println(title);
    }
    
    @Override
    public void renderDescription(String description) {
        System.out.println("- " + description);
    }
    
    @Override
    public void renderModuleInfo(String moduleName, int duration) {
        System.out.println("* " + moduleName + " [" + duration + "m]");
    }
    
    @Override
    public void renderQuizInfo(String quizTitle, int questions) {
        System.out.println("? " + quizTitle + " [" + questions + "Q]");
    }
    
    @Override
    public void renderSeparator() {
        System.out.println("---");
    }
}
