package com.platform.bridge;

public interface PresentationRenderer {
    void renderTitle(String title);
    void renderDescription(String description);
    void renderModuleInfo(String moduleName, int duration);
    void renderQuizInfo(String quizTitle, int questions);
    void renderSeparator();
}
