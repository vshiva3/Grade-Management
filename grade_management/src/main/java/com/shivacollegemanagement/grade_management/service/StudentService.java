package com.shivacollegemanagement.grade_management.service;

import com.shivacollegemanagement.grade_management.pojo.Student;

/**
 * StudentService
 */
public interface StudentService {
    Student getStudent(String studentId);
    Student saveStudent(Student student);
    Student updateStudentYear(Integer year, String studentId);
    void deleteStudent(String id);
}