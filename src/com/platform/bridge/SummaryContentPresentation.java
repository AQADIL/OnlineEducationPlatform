package com.platform.bridge;

import com.platform.model.Course;
import com.platform.model.Module;

public class SummaryContentPresentation extends ContentPresentation {
    
    public SummaryContentPresentation(PresentationRenderer renderer) {
        super(renderer);
    }
    
    @Override
    public void displayCourse(Course course) {
        renderer.renderTitle(course.getTitle());
        renderer.renderDescription(course.getDescription());
        
        for (Module module : course.getModules()) {
            displayModule(module);
        }
        
        renderer.renderSeparator();
    }
    
    @Override
    public void displayModule(Module module) {
        renderer.renderModuleInfo(module.getName(), module.getDurationMinutes());
    }
}
