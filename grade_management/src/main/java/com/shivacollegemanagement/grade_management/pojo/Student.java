package com.shivacollegemanagement.grade_management.pojo;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

    @NonNull
    @Column(name = "student_id")
    @Id
    private String id;

    @NonNull
    @Column(name = "student_name")
    private String studentName;

    @NonNull
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NonNull
    @Column(name = "gender")
    private String gender;

    @NonNull
    @Column(name = "branch")
    private String branch;

    @NonNull
    @Column(name = "year")
    private Integer year;

    @NonNull
    @Column(name = "mobile_number")
    private String mobileNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades;
}
