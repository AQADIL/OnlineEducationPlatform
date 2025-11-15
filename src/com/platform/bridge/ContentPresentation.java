package com.platform.bridge;

import com.platform.model.Course;
import com.platform.model.Module;

public abstract class ContentPresentation {
    protected PresentationRenderer renderer;
    
    public ContentPresentation(PresentationRenderer renderer) {
        this.renderer = renderer;
    }
    
    public abstract void displayCourse(Course course);
    public abstract void displayModule(Module module);

    public interface Renderer {
        void renderTitle(String title);
        void renderDescription(String description);
        void renderModuleInfo(String moduleName, int duration);
        void renderQuizInfo(String quizTitle, int questions);
        void renderSeparator();
    }
}
