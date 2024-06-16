package com.shivacollegemanagement.grade_management.service;

import java.util.List;

import com.shivacollegemanagement.grade_management.pojo.Grade;

/**
 * GradeService
 */
public interface GradeService {
    Grade getGrade(String studentId, String courseId);
    Grade saveGrade(Grade grade, String studentId, String courseId);
    Grade updateGrade(String score, String studentId, String courseId);
    void deleteGrade(String studentId, String courseId);
    List<Grade> getStudentGrades(String studentId);
    List<Grade> getCourseGrades(String courseId);
    List<Grade> getAllGrades();    
}
