package com.shivacollegemanagement.grade_management.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivacollegemanagement.grade_management.pojo.Course;
import com.shivacollegemanagement.grade_management.service.CourseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable String id) {
        return new ResponseEntity<>(courseService.getCourse(id), HttpStatus.OK);
    }

    @PostMapping("/faculty/{facultyId}")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course, @PathVariable Integer facultyId) {
        return new ResponseEntity<>(courseService.saveCourse(course, facultyId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/allcourses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/faculty/{facultyId}")
    public ResponseEntity<List<Course>> getAllCoursesByFaculty(@PathVariable Integer facultyId){
        return new ResponseEntity<>(courseService.getAllCoursesByFaculty(facultyId), HttpStatus.OK);
    }

    @PutMapping("/faculty/{facultyId}")
    public ResponseEntity<Course> updateFacultyForCourse(Integer facultyId){
        return new ResponseEntity<>(null);
    }
}
