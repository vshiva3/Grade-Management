package com.shivacollegemanagement.grade_management.exception;

public class GradeNotFoundException extends RuntimeException { 

    public GradeNotFoundException(String studentId, String courseId) {
        super("The grade with student id: '" + studentId + "' and course id: '" + courseId + "' does not exist in our records");
    }
    
}