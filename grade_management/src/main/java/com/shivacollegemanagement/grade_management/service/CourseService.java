package com.shivacollegemanagement.grade_management.service;

import java.util.List;

import com.shivacollegemanagement.grade_management.pojo.Course;

/**
 * CourseService
 */
public interface CourseService {
    Course getCourse(String id);
    Course saveCourse(Course course, Integer facultyId);
    void deleteCourse(String courseId);
    List<Course> getAllCourses();
    List<Course> getAllCoursesByFaculty(Integer facultyId);
}
