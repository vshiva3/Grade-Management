package com.shivacollegemanagement.grade_management.service;

import java.util.List;

import com.shivacollegemanagement.grade_management.pojo.Faculty;

/**
 * FacultyService
 */
public interface FacultyService {
    Faculty getFaculty(Integer id);
    Faculty saveFaculty(Faculty faculty);
    List<Faculty> getAllFaculty();
}
