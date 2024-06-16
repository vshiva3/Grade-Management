package com.shivacollegemanagement.grade_management.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivacollegemanagement.grade_management.pojo.Faculty;
import com.shivacollegemanagement.grade_management.service.FacultyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/faculty")
@RestController
public class FacultyController {
    FacultyService facultyService;

    @GetMapping("/{facultyId}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Integer facultyId){
        return new ResponseEntity<>(facultyService.getFaculty(facultyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Faculty> saveFaculty(@RequestBody Faculty faculty, String courseId){
        return new ResponseEntity<>(facultyService.saveFaculty(faculty), HttpStatus.CREATED);
    }

    @GetMapping("/allfaculty")
    public ResponseEntity<List<Faculty>> getAllFaculty(){
        return new ResponseEntity<>(facultyService.getAllFaculty(), HttpStatus.OK);
    }
}
