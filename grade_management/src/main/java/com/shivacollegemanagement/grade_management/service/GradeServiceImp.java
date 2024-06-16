package com.shivacollegemanagement.grade_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shivacollegemanagement.grade_management.exception.GradeNotFoundException;
import com.shivacollegemanagement.grade_management.pojo.Course;
import com.shivacollegemanagement.grade_management.pojo.Grade;
import com.shivacollegemanagement.grade_management.pojo.Student;
import com.shivacollegemanagement.grade_management.repository.CourseRepository;
import com.shivacollegemanagement.grade_management.repository.GradeRepository;
import com.shivacollegemanagement.grade_management.repository.StudentRepositry;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GradeServiceImp implements GradeService{
    GradeRepository gradeRepository;

    StudentRepositry studentRepository;

    CourseRepository courseRepository;

    @Override
    public Grade getGrade(String studentId, String courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        return grade.get();
    }

    @Override
    public Grade saveGrade(Grade grade, String studentId, String courseId) {
        Optional<Student> student =  studentRepository.findById(studentId);
        Optional<Course> course = courseRepository.findById(courseId);
        Course courseObj = CourseServiceImp.unwrapCourse(course, courseId);
        Student studentObj = StudentServiceImp.unwrapStudent(student, studentId);
        grade.setCourse(courseObj);
        grade.setStudent(studentObj);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, String studentId, String courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        Grade unwrappedGrade = unwrapGrade(grade, studentId, courseId);
        unwrappedGrade.setGrade(score);
        return gradeRepository.save(unwrappedGrade);
    }

    @Override
    public void deleteGrade(String studentId, String courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getStudentGrades(String studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(String courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }
    
    static Grade unwrapGrade(Optional<Grade> grade, String studentId, String courseId) {
        if (grade.isPresent()) return grade.get();
        else throw new GradeNotFoundException(studentId, courseId);
    }
}
