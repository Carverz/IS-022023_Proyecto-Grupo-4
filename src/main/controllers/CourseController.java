package main.controllers;

import main.models.Course;

public class CourseController {
    private Course course;
    
    public CourseController(Course course) {
        this.course = course;
    }
    
    public Course getCourse() {
        return course;
    }
    

}