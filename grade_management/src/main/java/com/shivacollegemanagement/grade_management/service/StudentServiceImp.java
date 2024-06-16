package com.shivacollegemanagement.grade_management.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shivacollegemanagement.grade_management.exception.StudentNotFoundException;
import com.shivacollegemanagement.grade_management.pojo.Student;
import com.shivacollegemanagement.grade_management.repository.StudentRepositry;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImp implements StudentService{

    StudentRepositry studentRepositry;

    public Student getStudent(String studentId){
        Optional<Student> student = studentRepositry.findById(studentId);
        Student studentObj = unwrapStudent(student, studentId);
        return studentObj;
    }

    public Student saveStudent(Student student){
        return studentRepositry.save(student);
    }

    @Override
    public Student updateStudentYear(Integer year, String studentId) {
        // TODO Auto-generated method stub
        Optional<Student> student = studentRepositry.findById(studentId);
        Student studentObj = unwrapStudent(student, studentId);
        studentObj.setYear(year);
        return studentRepositry.save(studentObj);
    }

    @Override
    public void deleteStudent(String id) {
        // TODO Auto-generated method stub
        Optional<Student> obj = studentRepositry.findById(id);
        Student studentObj = unwrapStudent(obj, id);
        studentRepositry.delete(studentObj);
    }

    public static Student unwrapStudent(Optional<Student> student, String id){
        if(student.isPresent()){
            return student.get();
        }else{
            throw new StudentNotFoundException(id);
        }
    }
}
