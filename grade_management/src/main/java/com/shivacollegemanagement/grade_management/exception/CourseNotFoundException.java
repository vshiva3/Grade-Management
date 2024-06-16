package com.shivacollegemanagement.grade_management.exception;

public class CourseNotFoundException extends RuntimeException { 

    public CourseNotFoundException(String id) {
        super("The course id '" + id + "' does not exist in our records");
    }
    
}