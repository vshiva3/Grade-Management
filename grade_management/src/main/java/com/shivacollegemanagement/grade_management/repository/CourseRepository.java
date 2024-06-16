package com.shivacollegemanagement.grade_management.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shivacollegemanagement.grade_management.pojo.Course;

public interface CourseRepository extends CrudRepository<Course, String>{
    List<Course> findByFacultyId(Integer facultyId);
}
