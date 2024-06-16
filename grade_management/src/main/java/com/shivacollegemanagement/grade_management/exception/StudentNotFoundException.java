package com.shivacollegemanagement.grade_management.exception;

public class StudentNotFoundException extends RuntimeException { 

    public StudentNotFoundException(String id) {
        super("The student id '" + id + "' does not exist in our records");
    }
    
}