package com.shivacollegemanagement.grade_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shivacollegemanagement.grade_management.exception.FacultyNotFoundException;
import com.shivacollegemanagement.grade_management.pojo.Faculty;
import com.shivacollegemanagement.grade_management.repository.FacultyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FacultyServiceImp implements FacultyService{

    FacultyRepository facultyRepository;

    @Override
    public Faculty getFaculty(Integer id) {
        // TODO Auto-generated method stub
        Optional<Faculty> facultyOptional = facultyRepository.findById(id);
        Faculty faculty = unwrapFaculty(facultyOptional, id);
        return faculty;
    }

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        // TODO Auto-generated method stub
        return facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> getAllFaculty() {
        // TODO Auto-generated method stub
        return (List<Faculty>)facultyRepository.findAll();
    }

    public static Faculty unwrapFaculty(Optional<Faculty> faculty, Integer id){
        if(faculty.isPresent()){
            return faculty.get();
        }else{
            throw new FacultyNotFoundException(id);
        }
    }
    
}
