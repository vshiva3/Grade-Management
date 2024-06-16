package com.shivacollegemanagement.grade_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.shivacollegemanagement.grade_management.pojo.Student;

/**
 * StudentRepositry
 */
public interface StudentRepositry extends CrudRepository<Student, String>{
        
}
