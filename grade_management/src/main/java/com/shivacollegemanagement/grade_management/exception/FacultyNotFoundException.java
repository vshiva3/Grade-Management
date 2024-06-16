package com.shivacollegemanagement.grade_management.exception;

public class FacultyNotFoundException extends RuntimeException{
    public FacultyNotFoundException(Integer id){
        super("The course id '" + id + "' does not exist in our records");
    }
}
