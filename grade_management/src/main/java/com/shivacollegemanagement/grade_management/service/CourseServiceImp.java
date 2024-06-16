package com.shivacollegemanagement.grade_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shivacollegemanagement.grade_management.exception.CourseNotFoundException;
import com.shivacollegemanagement.grade_management.pojo.Course;
import com.shivacollegemanagement.grade_management.pojo.Faculty;
import com.shivacollegemanagement.grade_management.repository.CourseRepository;
import com.shivacollegemanagement.grade_management.repository.FacultyRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImp implements CourseService{
    
    CourseRepository courseRepository;
    FacultyRepository facultyRepository;

    @Override
    public Course getCourse(String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        Course course = unwrapCourse(courseOptional, id);
        return course;
    }

    @Override
    public Course saveCourse(Course course, Integer facultyId) {
        Faculty faculty = FacultyServiceImp.unwrapFaculty(facultyRepository.findById(facultyId), facultyId);
        course.setFaculty(faculty);
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(String courseId) {
        // TODO Auto-generated method stub
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        unwrapCourse(courseOptional, courseId);
        courseRepository.deleteById(courseId);
    }

    public static Course unwrapCourse(Optional<Course> course, String id){
        if(course.isPresent()){
            return course.get();
        }else{
            throw new CourseNotFoundException(id);
        }
    }

    @Override
    public List<Course> getAllCourses() {
        // TODO Auto-generated method stub
        return (List<Course>)courseRepository.findAll();
    }

    @Override
    public List<Course> getAllCoursesByFaculty(Integer facultyId) {
        // TODO Auto-generated method stub
        return courseRepository.findByFacultyId(facultyId);
    }

}
