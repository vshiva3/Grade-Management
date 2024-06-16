package com.shivacollegemanagement.grade_management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.shivacollegemanagement.grade_management.pojo.Grade;

import jakarta.transaction.Transactional;

/**
 * GradeRepository
 */
public interface GradeRepository extends CrudRepository<Grade, Long>{
    Optional<Grade> findByStudentIdAndCourseId(String studentId, String courseId);
    @Transactional
    void deleteByStudentIdAndCourseId(String studentId, String courseId);
    List<Grade> findByStudentId(String studentId);
    List<Grade> findByCourseId(String courseId);
}