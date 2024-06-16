package com.shivacollegemanagement.grade_management.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "faculties")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {

    @Id
    @Column(name = "faculty_id")
    private Integer id;

    @Column(name = "faculty_name")
    private String facultyName;

    @JsonIgnore
    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<Course> courses;
}
